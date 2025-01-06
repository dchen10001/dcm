package com.nice.dcm.distribution.rule.parser.visit.nodewrapper;

import com.nice.dcm.simulation.distribution.node.BaseNode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class StringNodeImpl implements BaseNode {
	private final String value;
	@Override
	public String toExpression() {
		return value;
	}
}
