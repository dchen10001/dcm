package com.nice.antlr.ifstatement.node.action;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PrintDoActionImpl implements DoAction {
	private final double value;
	
	public PrintDoActionImpl(double value) {
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
