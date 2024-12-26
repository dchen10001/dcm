package com.nice.antlr.function.node;

public interface Expression {
	double eval(VariableStack variableStack);
	double eval();
	String toExpression();
	boolean multiVariable();
}
