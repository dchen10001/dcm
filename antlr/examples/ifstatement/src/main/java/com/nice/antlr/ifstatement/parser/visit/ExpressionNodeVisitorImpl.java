package com.nice.antlr.ifstatement.parser.visit;

import com.nice.antlr.ifstatement.node.expression.DoubleConstantImpl;
import com.nice.antlr.ifstatement.node.expression.DoubleVariableImpl;
import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.expression.ExpressionImpl;
import com.nice.antlr.ifstatement.node.expression.SignExpressionImpl;
import com.nice.antlr.ifstatement.node.operator.ArithmeticOp;
import com.nice.antlr.ifstatement.node.operator.ArithmeticSign;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ADDOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.DOUBLEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ExprContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.MULOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.SIGNGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.VARIABLEContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExpressionWrapperImpl;

public abstract class ExpressionNodeVisitorImpl extends AbstractNodeVisitorImpl {

	@Override
	public ExpressionWrapperImpl visitSIGNGRP(SIGNGRPContext ctx) {
		logger.trace("Visiting SIGNGRP: {}", ctx.getText());
		String sign = ctx.arithmeticsign().getText();
		ExpressionWrapperImpl node = (ExpressionWrapperImpl)visit(ctx.expr());
		SignExpressionImpl signNode = new SignExpressionImpl(ArithmeticSign.fromSymbol(sign), node.getExpression());
		return new ExpressionWrapperImpl(signNode);
	}
	
	@Override
	public ExpressionWrapperImpl visitMULOPGRP(MULOPGRPContext ctx) {
		logger.trace("Visiting MULOPGRP: {}", ctx.getText());
		String op = ctx.mulop().getText();
		return createConditionNode(op, ctx.expr(0), ctx.expr(1));
	}
	
	@Override
	public ExpressionWrapperImpl visitADDOPGRP(ADDOPGRPContext ctx) {
		logger.trace("Visiting ADDOPGRP: {}", ctx.getText());
		String op = ctx.addop().getText();
		return createConditionNode(op, ctx.expr(0), ctx.expr(1));
	}

	private ExpressionWrapperImpl createConditionNode(String op, ExprContext left, ExprContext right) {
		Expression l = ((ExpressionWrapperImpl)visit(left)).getExpression();
		Expression r = ((ExpressionWrapperImpl)visit(right)).getExpression();
		return new ExpressionWrapperImpl(new ExpressionImpl(ArithmeticOp.fromSymbol(op), l, r));
	}
	
	@Override
	public ExpressionWrapperImpl visitDOUBLE(DOUBLEContext ctx) {
		logger.trace("Visiting DOUBLE: {}", ctx.getText());
		Double d = Double.valueOf(ctx.DOUBLE().getText());
		DoubleConstantImpl numberNode = new DoubleConstantImpl(d);
		return new ExpressionWrapperImpl(numberNode);
	}

	@Override
	public ExpressionWrapperImpl visitVARIABLE(VARIABLEContext ctx) {
		logger.trace("Visiting VARIABLE: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		variableStack.addParameterVariable(variable, Double.class);
		DoubleVariableImpl variableNode = new DoubleVariableImpl(variable);
		return new ExpressionWrapperImpl(variableNode);
	}
}
