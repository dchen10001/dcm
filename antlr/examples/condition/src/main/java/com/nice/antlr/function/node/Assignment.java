package com.nice.antlr.function.node;

import lombok.NonNull;

public interface Assignment {
	void eval(@NonNull VariableStack variableStack);
	String toExpression();
}
