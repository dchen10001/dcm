package com.nice.antlr.ifstatement.node.condition;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class BooleanVariableImpl implements Condition {
	private final String name;

	public BooleanVariableImpl(String name) {
		this.name = name;
	}
	
	@Override
	public Boolean eval(@NonNull VariableStack variableStack) {
		Boolean value = variableStack.getVariableValue(name, Boolean.class);
		if (value == null) {
			value = Boolean.FALSE;
		}
		if (isDebugEnable()) {
			debug(name, value.toString());
		}
		return value;
	}

	@Override
	public String toExpression() {
		return this.name;
	}
}
