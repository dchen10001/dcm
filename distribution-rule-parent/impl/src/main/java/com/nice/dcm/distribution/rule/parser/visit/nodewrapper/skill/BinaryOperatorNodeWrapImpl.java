package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinaryOperator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for BINARY_OPERATOR node
 * operator: operator to be used in the rule to compare the skill level
 * supported operators: <, <=, >, >=, ==, !=
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class BinaryOperatorNodeWrapImpl implements NodeWrapper<BinaryOperator> {
	private final BinaryOperator operator;
	
	public BinaryOperatorNodeWrapImpl(String operator) {
        this.operator = BinaryOperator.fromString(operator);
    }

	@Override
	public BinaryOperator getNode() {
		return operator;
	}
}
