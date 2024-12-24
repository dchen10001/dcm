package com.nice.antlr.function.parser.node;

import java.util.List;

import com.nice.antlr.function.node.ExpressionNode;
import com.nice.antlr.function.node.ExpressionNodeImpl;
import com.nice.antlr.function.node.NumberNodeImpl;
import com.nice.antlr.function.node.VariableNodeImpl;
import com.nice.antlr.function.node.VariableStack;
import com.nice.antlr.function.node.VariableStackImpl;
import com.nice.antlr.function.node.operator.Operator;
import com.nice.antlr.function.node.operator.SignOperator;
import com.nice.antlr.function.parser.FunctionParser.ADDOPGRPContext;
import com.nice.antlr.function.parser.FunctionParser.DOUBLEContext;
import com.nice.antlr.function.parser.FunctionParser.MULOPGRPContext;
import com.nice.antlr.function.parser.FunctionParser.StartContext;
import com.nice.antlr.function.parser.FunctionParser.UMINUSContext;
import com.nice.antlr.function.parser.FunctionParser.VARIABLEContext;

public class FunctionNodeVisitorImpl extends AbstractFunctionNodeVisitorImpl {

	private VariableStack variableStack = new VariableStackImpl();

	public List<String> getVariableNames() {
		return variableStack.getVariableNames();
	}
	
	@Override
	public FunctionNode visitStart(StartContext ctx) {
		logger.debug("Visiting Start: {}", ctx.getText());
		variableStack.clear();
		return visitChildren(ctx);
	}

	@Override
	public FunctionNode visitUMINUS(UMINUSContext ctx) {
		logger.debug("Visiting UMINUS: {}", ctx.getText());
		FunctionNode node = this.visit(ctx.expr());
		node.getExpression().setSign(SignOperator.UMINUS);
		return node;
	}
	
	@Override
	public FunctionNode visitMULOPGRP(MULOPGRPContext ctx) {
		logger.debug("Visiting MULOPGRP: {}", ctx.getText());
		String op = ctx.mulop().getText();
		ExpressionNode left = visit(ctx.expr(0)).getExpression();
		ExpressionNode right = visit(ctx.expr(1)).getExpression();
		return new FunctionNodeImpl(new ExpressionNodeImpl(Operator.fromSymbol(op), left, right));
	}
	
	@Override
	public FunctionNode visitADDOPGRP(ADDOPGRPContext ctx) {
		logger.debug("Visiting ADDOPGRP: {}", ctx.getText());
		String op = ctx.addop().getText();
		ExpressionNode left = visit(ctx.expr(0)).getExpression();
		ExpressionNode right = visit(ctx.expr(1)).getExpression();
		return new FunctionNodeImpl(new ExpressionNodeImpl(Operator.fromSymbol(op), left, right));
	}

	@Override
	public FunctionNode visitDOUBLE(DOUBLEContext ctx) {
		logger.debug("Visiting DOUBLE: {}", ctx.getText());
		Double d = Double.valueOf(ctx.NUMBER().getText());
		NumberNodeImpl numberNode = new NumberNodeImpl(d);
		return new FunctionNodeImpl(numberNode);
	}

	@Override
	public FunctionNode visitVARIABLE(VARIABLEContext ctx) {
		logger.debug("Visiting VARIABLE: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		variableStack.initVariable(variable);
		VariableNodeImpl variableNode = new VariableNodeImpl(variable);
		return new FunctionNodeImpl(variableNode);
	}
}
