package com.nice.antlr.function.node;

import lombok.NonNull;

public interface Condition {
	boolean eval(@NonNull VariableStack variableStack);
	String toExpression();
}
