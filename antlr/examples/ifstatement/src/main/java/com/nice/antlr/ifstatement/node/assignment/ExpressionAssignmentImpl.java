package com.nice.antlr.ifstatement.node.assignment;

import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class ExpressionAssignmentImpl implements Assignment<Expression> {
	private final String variableName;
	private final Expression expression;
	
	public ExpressionAssignmentImpl(String variableName, Expression expression) {
		this.variableName = variableName;
		this.expression = expression;
	}

	@Override
	public Void eval(@NonNull VariableStack variableStack) {
        double value = expression.eval(variableStack);
        variableStack.setVariable(variableName, value);
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(value));
		}
		return null;
	}

	@Override
	public String getVariableName() {
		return variableName;
	}
	
	public Expression getRightValue() {
		return this.expression;
	}

	@Override
	public Class<Double> getValueType() {
		return Double.class;
	}
}
