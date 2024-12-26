package com.nice.antlr.function.parser.node;

import com.nice.antlr.function.node.Condition;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConditionNodeImpl implements Node {

	private final Condition condition;

	public ConditionNodeImpl(Condition condition) {
		this.condition = condition;
	}

	@Override
	public Object getObject() {
		return getCondition();
	}
}
