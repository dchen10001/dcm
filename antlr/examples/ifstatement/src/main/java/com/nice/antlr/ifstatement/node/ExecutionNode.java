package com.nice.antlr.ifstatement.node;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public interface ExecutionNode<T> extends BaseNode {
	T eval(@NonNull VariableStack variableStack);
}
