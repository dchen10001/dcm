package com.nice.antlr.function.node.condition;

import com.nice.antlr.function.node.variable.VariableStack;

import lombok.NonNull;

public class BooleanVariableImpl implements Condition {
	private final String name;

	public BooleanVariableImpl(String name) {
		this.name = name;
	}
	
	@Override
	public Boolean eval(@NonNull VariableStack variableStack) {
		Boolean value = variableStack.getVariableValue(name, Boolean.class);
		if (value != null) {
			return value;
		}
		return false;
	}

	@Override
	public String toExpression() {
		return this.name;
	}
}
