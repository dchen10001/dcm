package com.nice.antlr.function.parser.visit.nodewrapper;

import com.nice.antlr.function.node.expression.Expression;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ExpressionWrapperImpl implements NodeWrapper<Expression> {
	private final Expression expression;

	public ExpressionWrapperImpl(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Expression getNode() {
		return getExpression();
	}
}
