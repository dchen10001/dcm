package com.nice.antlr.function.node.expression;

import com.nice.antlr.function.node.variable.VariableStack;

import lombok.ToString;

@ToString
public class DoubleVariableImpl implements Expression {
	
	private final String name;
		
	public DoubleVariableImpl(String name) {
		this.name = name;
	}
	
	public double getValue(VariableStack variableStack) {
		if (variableStack == null) {
			return 0d;
		}
		Double d = variableStack.getVariableValue(name, Double.class);
		double v =  (d == null)  ? 0d : d;
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(v));
		}
		return v;
	}

	@Override
	public Double eval(VariableStack variableStack) {
		return getValue(variableStack);
	}

	@Override
	public String toExpression() {
		return name;
	}	
	
	@Override
	public boolean multiVariable() {
		return false;
	}
}
