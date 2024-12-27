package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.ArithmeticSign;

import lombok.ToString;

@ToString
public class NumberImpl implements Expression {
	private final double value;
	private ArithmeticSign sign;
	
	public NumberImpl(double value) {
		this.value = value;
	}

	public double getValue() {
		if (sign == null) {
			return value;
		}
		return sign.eval(value);
	}

	@Override
	public double eval(VariableStack variableStack) {
		return getValue();
	}

	@Override
	public String toExpression() {
		if (sign != null)
			return sign.getSymbol() + value;
		return String.valueOf(value);
	}

	@Override
	public boolean multiVariable() {
		return false;
	}
}
