package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.SignOperator;

public interface ExpressionNode {
	void setSign(SignOperator operator);
	double eval(VariableStack variableStack);
	double eval();
	String toExpression();
	boolean multiVariable();
}
