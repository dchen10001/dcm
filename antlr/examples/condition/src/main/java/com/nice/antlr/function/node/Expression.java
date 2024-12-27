package com.nice.antlr.function.node;

import lombok.NonNull;

public interface Expression {
	double eval(@NonNull VariableStack variableStack);
	String toExpression();
	boolean multiVariable();
}
