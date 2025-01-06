package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import java.util.List;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;
import com.nice.dcm.simulation.distribution.node.rule.skill.SkillSetSelectorImpl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
public class SkillSetSelectorNodeWrapImpl implements NodeWrapper<SkillSetSelector> {
	
	private final SkillSetSelector skillSetSelector;
	
	public SkillSetSelectorNodeWrapImpl(List<SkillSelector> skillSelectors) {
		this.skillSetSelector = new SkillSetSelectorImpl(skillSelectors);
	}
	
	public SkillSetSelectorNodeWrapImpl(SkillSelector skillSelector) {
		this.skillSetSelector = new SkillSetSelectorImpl(skillSelector);
	}

	@Override
	public SkillSetSelector getNode() {
		return skillSetSelector;
	}
}
