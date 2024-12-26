package com.nice.antlr.function.node;

public interface Condition {
	boolean eval(VariableStack variableStack);
	boolean eval();
	String toExpression();
}
