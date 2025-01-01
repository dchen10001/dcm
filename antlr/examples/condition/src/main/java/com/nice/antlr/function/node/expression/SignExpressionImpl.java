package com.nice.antlr.function.node.expression;

import com.nice.antlr.function.node.operator.ArithmeticSign;
import com.nice.antlr.function.node.variable.VariableStack;

public class SignExpressionImpl implements Expression {
	private ArithmeticSign sign;
	private Expression expression;
	
	public SignExpressionImpl(ArithmeticSign sign, Expression expression) {
		this.sign = sign;
		this.expression = expression;
	}
	
	@Override
	public Double eval(VariableStack variableStack) {
		return sign.eval(expression.eval(variableStack));
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append(sign.getSymbol())
			.append("(")
			.append(expression.toExpression())
			.append(")");
		return sb.toString();
	}

	@Override
	public boolean multiVariable() {
		return true;
	}

}
