package com.nice.antlr.function.parser.node;

import java.util.List;

import com.nice.antlr.condition.parser.ConditionParser.ADDOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.BINARYGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.DOUBLEContext;
import com.nice.antlr.condition.parser.ConditionParser.ExprContext;
import com.nice.antlr.condition.parser.ConditionParser.LOGICALGRPTContext;
import com.nice.antlr.condition.parser.ConditionParser.MULOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.RELOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.SIGNGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.StartContext;
import com.nice.antlr.condition.parser.ConditionParser.VARIABLEContext;
import com.nice.antlr.function.node.Condition;
import com.nice.antlr.function.node.ConditionImpl;
import com.nice.antlr.function.node.Expression;
import com.nice.antlr.function.node.ExpressionImpl;
import com.nice.antlr.function.node.LogicConditionImpl;
import com.nice.antlr.function.node.NumberImpl;
import com.nice.antlr.function.node.SignConditionImpl;
import com.nice.antlr.function.node.SignExpressionImpl;
import com.nice.antlr.function.node.VariableImpl;
import com.nice.antlr.function.node.VariableStack;
import com.nice.antlr.function.node.VariableStackImpl;
import com.nice.antlr.function.node.operator.ArithmeticOp;
import com.nice.antlr.function.node.operator.ArithmeticSign;
import com.nice.antlr.function.node.operator.BinaryOp;
import com.nice.antlr.function.node.operator.BinarySign;
import com.nice.antlr.function.node.operator.LogicOp;

public class NodeVisitorImpl extends AbstractNodeVisitorImpl {

	private VariableStack variableStack = new VariableStackImpl();

	public List<String> getVariableNames() {
		return variableStack.getVariableNames();
	}
	
	@Override
	public ConditionNodeImpl visitStart(StartContext ctx) {
		logger.debug("Visiting Start: {}", ctx.getText());
		variableStack.clear();
		return (ConditionNodeImpl)visitChildren(ctx);
	}
	
	@Override
	public ConditionNodeImpl visitLOGICALGRPT(LOGICALGRPTContext ctx) {
		logger.debug("Visiting LOGICALGRP: {}", ctx.getText());
		String op = ctx.logicalop().getText();
		Condition left = ((ConditionNodeImpl)visit(ctx.conditiongroup(0))).getCondition();
		Condition right = ((ConditionNodeImpl)visit(ctx.conditiongroup(1))).getCondition();
		Condition condition = new LogicConditionImpl(LogicOp.fromSymbol(op), left, right);
		return new ConditionNodeImpl(condition);
	}
	

	@Override
	public ConditionNodeImpl visitBINARYGRP(BINARYGRPContext ctx) {
		logger.debug("Visiting BINARYGRP: {}", ctx.getText());
		String sign = ctx.binarysign().getText();
		ConditionNodeImpl node = (ConditionNodeImpl)visit(ctx.conditiongroup());
		SignConditionImpl condition = new SignConditionImpl(BinarySign.fromSymbol(sign), node.getCondition());
		return new ConditionNodeImpl(condition);
	}
	
	@Override
	public Node visitRELOPGRP(RELOPGRPContext ctx) {
		logger.debug("Visiting RELOPGRP: {}", ctx.getText());
		String op = ctx.relop().getText();
		Expression l = ((ExpressionNodeImpl)visit(ctx.expr(0))).getExpression();
		Expression r = ((ExpressionNodeImpl)visit(ctx.expr(1))).getExpression();
		Condition condition = new ConditionImpl(BinaryOp.fromSymbol(op), l, r);
		return new ConditionNodeImpl(condition);
	}

	@Override
	public Node visitSIGNGRP(SIGNGRPContext ctx) {
		logger.debug("Visiting SIGNGRP: {}", ctx.getText());
		String sign = ctx.arithmeticsign().getText();
		ExpressionNodeImpl node = (ExpressionNodeImpl)visit(ctx.expr());
		SignExpressionImpl signNode = new SignExpressionImpl(ArithmeticSign.fromSymbol(sign), node.getExpression());
		return new ExpressionNodeImpl(signNode);
	}
	
	@Override
	public Node visitMULOPGRP(MULOPGRPContext ctx) {
		logger.debug("Visiting MULOPGRP: {}", ctx.getText());
		String op = ctx.mulop().getText();
		return createConditionNode(op, ctx.expr(0), ctx.expr(1));
	}
	
	@Override
	public Node visitADDOPGRP(ADDOPGRPContext ctx) {
		logger.debug("Visiting ADDOPGRP: {}", ctx.getText());
		String op = ctx.addop().getText();
		return createConditionNode(op, ctx.expr(0), ctx.expr(1));
	}

	private Node createConditionNode(String op, ExprContext left, ExprContext right) {
		Expression l = ((ExpressionNodeImpl)visit(left)).getExpression();
		Expression r = ((ExpressionNodeImpl)visit(right)).getExpression();
		return new ExpressionNodeImpl(new ExpressionImpl(ArithmeticOp.fromSymbol(op), l, r));
	}
	
	@Override
	public ExpressionNodeImpl visitDOUBLE(DOUBLEContext ctx) {
		logger.debug("Visiting DOUBLE: {}", ctx.getText());
		Double d = Double.valueOf(ctx.DOUBLE().getText());
		NumberImpl numberNode = new NumberImpl(d);
		return new ExpressionNodeImpl(numberNode);
	}

	@Override
	public ExpressionNodeImpl visitVARIABLE(VARIABLEContext ctx) {
		logger.debug("Visiting VARIABLE: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		variableStack.initVariable(variable);
		VariableImpl variableNode = new VariableImpl(variable);
		return new ExpressionNodeImpl(variableNode);
	}
}
