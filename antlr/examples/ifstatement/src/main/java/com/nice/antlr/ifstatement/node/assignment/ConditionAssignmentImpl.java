package com.nice.antlr.ifstatement.node.assignment;

import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class ConditionAssignmentImpl implements Assignment<Condition> {
	private final String variableName;
	private final Condition condition;

	public ConditionAssignmentImpl(String variableName, Condition condition) {
		this.variableName = variableName;
		this.condition = condition;
	}

	@Override
	public Void eval(@NonNull VariableStack variableStack) {
		boolean value = condition.eval(variableStack);
        variableStack.setVariable(variableName, value);
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(value));
		}
		return null;
	}

	@Override
	public String getVariableName() {
		return this.variableName;
	}

	@Override
	public Condition getRightValue() {
		return this.condition;
	}

	@Override
	public Class<Boolean> getValueType() {
		return Boolean.class;
	}
}
