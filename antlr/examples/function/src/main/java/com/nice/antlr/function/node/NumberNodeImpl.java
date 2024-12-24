package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.SignOperator;

import lombok.ToString;

@ToString
public class NumberNodeImpl implements ExpressionNode {
	private final double value;
	private SignOperator sign;
	
	public NumberNodeImpl(double value) {
		this.value = value;
	}

	public double getValue() {
		if (sign == null) {
			return value;
		}
		return sign.eval(value);
	}

	@Override
	public double eval() {
		return getValue();
	}

	@Override
	public double eval(VariableStack variableStack) {
		return getValue();
	}

	@Override
	public void setSign(SignOperator operator) {
        this.sign = operator;
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
