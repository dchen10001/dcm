package com.nice.antlr.ifstatement.node.expression;

import com.nice.antlr.ifstatement.node.ExecutionNode;

public interface Expression extends ExecutionNode<Double> {
	boolean multiVariable();
}
