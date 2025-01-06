package com.nice.antlr.ifstatement.node.assignment;

import com.nice.antlr.ifstatement.node.ExecutionNode;

public interface Assignment<V extends ExecutionNode<?>> extends ExecutionNode<Void> {
	String getVariableName();

	V getRightValue();
	
	Class<?> getValueType();
	
	default String toExpression() {
		return "set " + getVariableName() + " = " + this.getRightValue().toExpression();
	}
}
