package com.nice.dcm.simulation.distribution.action;

import java.util.List;
import java.util.Map;

public interface QueueToActions {
	List<QueueToAction> getActions();
	
	QueueToTarget buildTarget(int skillSelectorId, QueueToAction action);
	
	default QueueToTarget evaluate(Map<String, Integer> skillToLevels) {
		if (skillToLevels == null || skillToLevels.isEmpty()) {
			return null;
		}

		for (QueueToAction action : getActions()) {
			int selectorId = action.evaluate(skillToLevels);
			
			if (selectorId != QueueToAction.INVALID_SKILL_SELECTOR) {
				return buildTarget(selectorId, action);
			}
		}
		return null;
	}
}
