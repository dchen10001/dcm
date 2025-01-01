package com.nice.antlr.function.node.expression;

import com.nice.antlr.function.node.variable.VariableStack;

import lombok.ToString;

@ToString
public class DoubleConstantImpl implements Expression {
	private final double value;
	
	public DoubleConstantImpl(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public Double eval(VariableStack variableStack) {
		return getValue();
	}

	@Override
	public String toExpression() {
		return String.valueOf(value);
	}

	@Override
	public boolean multiVariable() {
		return false;
	}
}
