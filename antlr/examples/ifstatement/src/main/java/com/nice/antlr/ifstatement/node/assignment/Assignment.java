package com.nice.antlr.ifstatement.node.assignment;

import com.nice.antlr.ifstatement.node.BaseNode;

public interface Assignment<V extends BaseNode<?>> extends BaseNode<Void> {
	String getVariableName();

	V getRightValue();
	
	Class<?> getValueType();
	
	default String toExpression() {
		return "set " + getVariableName() + " = " + this.getRightValue().toExpression();
	}
}
