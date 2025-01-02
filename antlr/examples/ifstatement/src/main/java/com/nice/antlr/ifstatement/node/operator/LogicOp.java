package com.nice.antlr.ifstatement.node.operator;

import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

public enum LogicOp {
	AND("&&")
    {
		@Override
		public boolean eval(VariableStack variableStack, Condition left, Condition right) {
			if(!left.eval(variableStack)) {
				return false;
			}
            return right.eval(variableStack);
		}
	}, 
	
	OR("||")
	{
		@Override
		public boolean eval(VariableStack variableStack, Condition left, Condition right) {
			if(left.eval(variableStack)) {
				return true;
			}
            return right.eval(variableStack);
		}
	};

	private final String symbol;

	LogicOp(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static LogicOp fromSymbol(String symbol) {
		for (LogicOp operator : values()) {
			if (operator.symbol.equals(symbol)) {
				return operator;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
	
	public boolean eval(VariableStack variableStack,  Condition left, Condition right) {
		throw new UnsupportedOperationException();
	}	
}
