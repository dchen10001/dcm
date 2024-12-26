package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.ArithmeticSign;

public class SignExpressionImpl implements Expression {
	private ArithmeticSign sign;
	private Expression expression;
	
	public SignExpressionImpl(ArithmeticSign sign, Expression expression) {
		this.sign = sign;
		this.expression = expression;
	}
	
	@Override
	public double eval(VariableStack variableStack) {
		return sign.eval(expression.eval(variableStack));
	}

	@Override
	public double eval() {
		return eval(null);
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
