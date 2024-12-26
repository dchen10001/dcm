package com.nice.antlr.function.parser.node;

import com.nice.antlr.function.node.Expression;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ExpressionNodeImpl implements Node {
	private final Expression expression;

	public ExpressionNodeImpl(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object getObject() {
		return getExpression();
	}
}
