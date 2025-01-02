package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.condition.Condition;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class ConditionWrapperImpl implements NodeWrapper<Condition> {

	private final Condition condition;

	public ConditionWrapperImpl(@NonNull Condition condition) {
		this.condition = condition;
	}

	@Override
	public Condition getNode() {
		return getCondition();
	}
}
