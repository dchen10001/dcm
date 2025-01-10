package com.nice.dcm.simulation.distribution.node.rule.skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public class SkillSetSelectorImpl implements SkillSetSelector {
	private final List<SkillSelector> skillSelectors;
	
	public SkillSetSelectorImpl(@NonNull List<SkillSelector> skillSelectors) {
		if (skillSelectors.isEmpty()) {
            throw new IllegalArgumentException("skillSelectors is empty");
		}
		
		Set<SkillSelector> selectorSet = skillSelectors.stream().collect(Collectors.toSet());
		if (selectorSet.size() < skillSelectors.size()) {
			skillSelectors = new ArrayList<>(selectorSet);
		}
		this.skillSelectors = skillSelectors;
	}
	
	public SkillSetSelectorImpl(@NonNull SkillSelector skillSelector) {
		super();
		this.skillSelectors = List.of(skillSelector);
	}

	@Override
	public String toString() {
		return toExpression();
	}
	
	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (SkillSelector selector : skillSelectors) {
			sb.append("(").append(selector.toExpression()).append(")");
			if (!first) {
				sb.append(", ");
			}
			first = false;
		}
		return sb.toString();
	}
}
