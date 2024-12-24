package com.nice.antlr.function.parser.node;

import com.nice.antlr.function.node.ExpressionNode;

import lombok.ToString;

@ToString
public class FunctionNodeImpl implements FunctionNode {
	private final ExpressionNode expression;

	public FunctionNodeImpl(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public ExpressionNode getExpression() {
		return expression;
	}
}
