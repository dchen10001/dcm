package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.expression.Expression;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
public class ExpressionWrapperImpl implements NodeWrapper<Expression> {
	private final Expression expression;

	public ExpressionWrapperImpl(@NonNull Expression expression) {
		this.expression = expression;
	}

	@Override
	public Expression getNode() {
		return getExpression();
	}
}
	