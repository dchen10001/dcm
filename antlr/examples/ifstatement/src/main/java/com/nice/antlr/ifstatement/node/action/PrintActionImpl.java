package com.nice.antlr.ifstatement.node.action;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PrintActionImpl implements Action {
	private final double value;
	
	public PrintActionImpl(double value) {
		this.value = value;
	}
	
	@Override
	public String toExpression() {
		return "PRINT " + value;
	}

	@Override
	public Void eval(@NonNull VariableStack variableStack) {
		System.out.println("Action: " + value);
		return null;
	}

}
