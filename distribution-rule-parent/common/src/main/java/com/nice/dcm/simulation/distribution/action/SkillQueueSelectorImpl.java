package com.nice.dcm.simulation.distribution.action;

import java.util.List;

import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SkillQueueSelectorImpl implements SkillQueueSelector {
	private final int id;
	private final SkillSetSelector selector;
	
	public SkillQueueSelectorImpl(SkillSetSelector selector) {
		this.id = SkillQueueSelector.generateId();
		this.selector = selector;
	}
	
	@Override
	public List<SkillSelector> getSkillSelectors() {
		return selector.getSkillSelectors();
	}

	@Override
	public String toExpression() {
		return "SkillQueueId = " + id + ", " + selector.toExpression();
	}
	
	@Override
	public String toString() {
		return toExpression();
	}
}
