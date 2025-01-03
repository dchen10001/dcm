package com.nice.antlr.ifstatement.node.condition;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BooleanConstantImpl implements Condition {
	private final boolean value;
	
	public BooleanConstantImpl(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toExpression() {
		return String.valueOf(value);
	}

	@Override
	public Boolean eval(VariableStack variableStack) {
		return isValue();
	}
}
