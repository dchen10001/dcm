package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for CONDITION node condition: condition to be evaluated
 * Condition: condition to be evaluated, it is either a binary condition or 
 * a sql condition.
 * @see Condition
 *
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class SkillLevelConditionNodeWrapImpl implements NodeWrapper<SkillLevelCondition> {
	private final SkillLevelCondition condition;

	@Override
	public SkillLevelCondition getNode() {
		return condition;
	}
}
