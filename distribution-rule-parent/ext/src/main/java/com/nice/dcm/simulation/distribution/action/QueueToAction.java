package com.nice.dcm.simulation.distribution.action;

import java.util.Map;
import java.util.Set;

import com.nice.dcm.simulation.distribution.node.BaseNode;

/**
 * interface of action for queue to action.
 * @author David Chen 
 */
public interface QueueToAction extends Comparable<QueueToAction>, BaseNode {
	public static final int INVALID_SKILL_SELECTOR = -1;
	Set<SkillQueueSelector> getSelectors();
	
	int getPriority();
	
	boolean isLeastBusy();
	
	default int evaluate(Map<String, Integer> skillToLevels) {
		if (skillToLevels == null || skillToLevels.isEmpty()) {
			return INVALID_SKILL_SELECTOR;
		}
		
		debug("evaluate queue to action: ", toExpression());
		for (SkillQueueSelector selector : getSelectors()) {
			if (selector.evaluate(skillToLevels)) {
				debug("evaluate selector: ", selector.toExpression(), " is true.");
				return selector.getId();
			}
			debug("evaluate selector: ", selector.toExpression(), " is false.");
		}
		debug("evaluate queue to action: false");
		return INVALID_SKILL_SELECTOR;
	}
}
