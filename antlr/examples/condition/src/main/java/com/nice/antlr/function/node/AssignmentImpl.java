package com.nice.antlr.function.node;

import lombok.NonNull;

public class AssignmentImpl implements Assignment {
	private String variableName;
	private Expression expression;
	
	public AssignmentImpl(String variableName, Expression expression) {
		this.variableName = variableName;
		this.expression = expression;
	}

	@Override
	public void eval(@NonNull VariableStack variableStack) {
        double value = expression.eval(variableStack);
        variableStack.setVariable(variableName, value);
		if(Execution.isDebugEnable()) {
			Execution.debug(toExpression(), String.valueOf(value));
		}
	}
	
	@Override
	public String toExpression() {
		return "set " + variableName + " = " + expression.toExpression();
	}
}
