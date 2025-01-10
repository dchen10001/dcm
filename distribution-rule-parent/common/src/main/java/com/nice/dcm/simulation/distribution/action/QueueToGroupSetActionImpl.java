package com.nice.dcm.simulation.distribution.action;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class QueueToGroupSetActionImpl implements QueueToGroupSetAction {
	private final QueueToGroupAction defaultGroupAction;
	private final List<QueueToGroupAction> groupActions;
	
	private QueueToActions defaultActions = null;
	private long[] waitingTimes = null;
	private QueueToActions[] waitingGroupActions = null;
	
	public QueueToGroupSetActionImpl(QueueToGroupAction defaultGroupAction) {
		this(defaultGroupAction, List.of());
	}
	
	public QueueToGroupSetActionImpl(@NonNull QueueToGroupAction defaultGroupAction, List<QueueToGroupAction> groupActions) {
		if (defaultGroupAction.getWaitAfterSeconds() != 0) {
			throw new IllegalArgumentException("waitAfterSeconds of default group action should be 0.");
		}

		this.defaultGroupAction = defaultGroupAction;
        if (groupActions == null || groupActions.isEmpty()) {
        	this.groupActions = List.of();
        } else {
        	this.groupActions = groupActions;
        }
        init();
	}

	protected void init() {
		ArrayList<QueueToAction> defaultActionList = new ArrayList<>(defaultGroupAction.getActions());
		defaultActionList.sort(null);
		defaultActions = new QueueToActionsImpl(defaultActionList);
		
		
		this.waitingTimes = new long[groupActions.size()];
		this.waitingGroupActions = new QueueToActions[groupActions.size()];
		int index = 0;
		long waitingTime = 0;
		List<QueueToAction> waitingGroupAction = new ArrayList<>(defaultActionList);
		
		for (QueueToGroupAction groupAction : groupActions) {
			waitingTimes[index] = waitingTime + groupAction.getWaitAfterSeconds();
			waitingTime = waitingTimes[index];

			waitingGroupAction.addAll(groupAction.getActions());
			waitingGroupAction.sort(null);
			waitingGroupActions[index] = new QueueToActionsImpl(waitingGroupAction);
			index++;
		}
	}
	
	@Override
	public QueueToActions getActions() {
		return defaultActions;
	}
	
	@Override
	public QueueToActions getActions(long waitingSeconds) {
		if (waitingSeconds < 0) {
			throw new IllegalArgumentException("waitingSeconds is less than 0");
		}
		if (waitingSeconds == 0) {
			return getActions();
		}
		int index = getIndex(waitingSeconds);
		return (index < 0) ? defaultActions : waitingGroupActions[index];
	}
	
	private int getIndex(long waitingSeconds) {
		int index = -1;
		for (long waitingTime : waitingTimes) {
			if (waitingSeconds < waitingTime) {
				break;
			}
			index++;
		}
		return index;
	}
}
