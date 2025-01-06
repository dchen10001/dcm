package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlOperator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for SQL_OPERATOR node operator: SQL style operator
 * supported operators: IN, NOT IN, 
 * future support(maybe) BETWEEN, NOT BETWEEN
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class SqlOperatorNodeWrapImpl implements NodeWrapper<SqlOperator> {
	private final SqlOperator operator;
	
    public SqlOperatorNodeWrapImpl(String operator) {
        this.operator = SqlOperator.fromString(operator);
    }

	@Override
	public SqlOperator getNode() {
		return operator;
	}
}
