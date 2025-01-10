package com.nice.dcm.simulation.distribution.action;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueueToActionsImpl implements QueueToActions {
	private final List<QueueToAction> actions;

	@Override
	public QueueToTarget buildTarget(int skillSelectorId, QueueToAction action) {
		return new QueueToTargetImpl(skillSelectorId, action.getPriority(), action.isLeastBusy());
	}
}
