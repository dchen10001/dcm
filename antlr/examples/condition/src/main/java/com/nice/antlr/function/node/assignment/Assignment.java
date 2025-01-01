package com.nice.antlr.function.node.assignment;

import com.nice.antlr.function.node.BaseNode;

public interface Assignment<V extends BaseNode<?>> extends BaseNode<Void> {
	String getVariableName();

	V getRightValue();
	
	default String toExpression() {
		return "set " + getVariableName() + " = " + this.getRightValue().toExpression();
	}
}
