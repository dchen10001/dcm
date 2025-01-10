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
		
		//AND relationship, all skill selectors should be satisfied
		for (SkillSelector skillSelector : getSkillSelectors()) {
			String skillOid = skillSelector.getSkillOid();
			boolean flag = skillToLevels.containsKey(skillOid);
			debug("skill set contains ", skillOid, String.valueOf(flag));
			
			if (flag) {
				int level = skillToLevels.get(skillOid);
				debug("skill level of", skillOid, "=", String.valueOf(level));

				flag = skillSelector.evaluate(skillOid, level);
				debug("skill level condition of", skillOid, "=", String.valueOf(flag));
				if (!flag) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}	
}
