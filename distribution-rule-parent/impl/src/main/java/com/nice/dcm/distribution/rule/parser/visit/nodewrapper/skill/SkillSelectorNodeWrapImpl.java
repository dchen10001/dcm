package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;
import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.skill.SkillSelectorImpl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
public class SkillSelectorNodeWrapImpl implements NodeWrapper<SkillSelector> {
	private final SkillSelector skillSelector;
	
	public SkillSelectorNodeWrapImpl(String skillOid) {
		this.skillSelector = new SkillSelectorImpl(skillOid);
	}
	
	public SkillSelectorNodeWrapImpl(String skillOid, SkillLevelCondition condition) {
		this.skillSelector = new SkillSelectorImpl(skillOid, condition);
	}

	@Override
	public SkillSelector getNode() {
		return skillSelector;
	}
}
