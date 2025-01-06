package com.nice.dcm.simulation.distribution.node.rule;

import java.util.List;
import java.util.Map;

import com.nice.dcm.simulation.distribution.node.BaseNode;

/**
 * a list of skill selectors with AND relationship
 * 
 * @see SkillSelector
 * 
 * @author David Chen
 */
public interface SkillSetSelector extends BaseNode {
	/**
	 * 
	 * @return the map of skill selectors, key is the skill oid.
	 */
	List<SkillSelector> getSkillSelectors();
	
	default boolean evaluate(Map<String, Integer> skillToLevels) {
		if (skillToLevels == null || skillToLevels.isEmpty()) {
			return false;
		}
		for (SkillSelector skillSelector : getSkillSelectors()) {
			String skillOid = skillSelector.getSkillOid();
			if (!skillToLevels.containsKey(skillOid)) {
				return false;
			} else {
				int level = skillToLevels.get(skillOid);
				if (!skillSelector.evaluate(skillOid, level)) {
					return false;
				}
			}
		}
		return true;
	}	
}
