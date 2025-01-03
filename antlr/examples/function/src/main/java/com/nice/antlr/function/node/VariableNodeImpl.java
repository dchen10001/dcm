package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.SignOperator;

import lombok.ToString;

@ToString
public class VariableNodeImpl implements ExpressionNode {
	
	private final String name;
	
	private SignOperator sign;
	
	public VariableNodeImpl(String name) {
		this.name = name;
	}
	
	public double getValue(VariableStack variableStack) {
		if (variableStack == null) {
			return 0d;
		}
		double d = variableStack.getVariable(name);
		if (sign == null)
			return d;
		return sign.eval(d);
	}

	@Override
	public double eval(VariableStack variableStack) {
		return getValue(variableStack);
	}

	@Override
	public double eval() {
		return eval(null);
	}
	
	@Override
	public void setSign(SignOperator operator) {
        this.sign = operator;
	}

	@Override
	public String toExpression() {
		if (sign != null)
			return sign.getSymbol() + name;
		return name;
	}	
	
	@Override
	public boolean multiVariable() {
		return false;
	}
}
