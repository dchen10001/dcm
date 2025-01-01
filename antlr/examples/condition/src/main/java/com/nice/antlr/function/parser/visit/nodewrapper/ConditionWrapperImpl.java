package com.nice.antlr.function.parser.visit.nodewrapper;

import com.nice.antlr.function.node.condition.Condition;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConditionWrapperImpl implements NodeWrapper<Condition> {

	private final Condition condition;

	public ConditionWrapperImpl(Condition condition) {
		this.condition = condition;
	}

	@Override
	public Condition getNode() {
		return getCondition();
	}
}
