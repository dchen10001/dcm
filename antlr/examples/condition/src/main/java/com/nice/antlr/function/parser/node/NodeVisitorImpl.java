package com.nice.antlr.function.parser.node;

import java.util.List;

import com.nice.antlr.condition.parser.ConditionParser.ADDOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.ASSSIGNMENTContext;
import com.nice.antlr.condition.parser.ConditionParser.BINARYGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.DOUBLEContext;
import com.nice.antlr.condition.parser.ConditionParser.ExprContext;
import com.nice.antlr.condition.parser.ConditionParser.LOGICALGRPTContext;
import com.nice.antlr.condition.parser.ConditionParser.MULOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.RELOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.SIGNGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.StartContext;
import com.nice.antlr.condition.parser.ConditionParser.VARIABLEContext;
import com.nice.antlr.function.node.Assignment;
import com.nice.antlr.function.node.AssignmentImpl;
import com.nice.antlr.function.node.Condition;
import com.nice.antlr.function.node.ConditionImpl;
import com.nice.antlr.function.node.Execution;
import com.nice.antlr.function.node.ExecutionImpl;
import com.nice.antlr.function.node.Expression;
import com.nice.antlr.function.node.ExpressionImpl;
import com.nice.antlr.function.node.LogicConditionImpl;
import com.nice.antlr.function.node.NodeVariableStack;
import com.nice.antlr.function.node.NodeVariableStackImpl;
import com.nice.antlr.function.node.NumberImpl;
import com.nice.antlr.function.node.SignConditionImpl;
import com.nice.antlr.function.node.SignExpressionImpl;
import com.nice.antlr.function.node.VariableImpl;
import com.nice.antlr.function.node.operator.ArithmeticOp;
import com.nice.antlr.function.node.operator.ArithmeticSign;
import com.nice.antlr.function.node.operator.BinaryOp;
import com.nice.antlr.function.node.operator.BinarySign;
import com.nice.antlr.function.node.operator.LogicOp;

public class NodeVisitorImpl extends AbstractNodeVisitorImpl {

	private NodeVariableStack variableStack = new NodeVariableStackImpl();

	public List<String> getVariableNames() {
		return variableStack.getVariableNames();
	}
	
	public List<String> getAssignmentNames() {
		return this.variableStack.getAssignmentVariable();
	}
	
	@Override
	public ExecutionNodeImpl visitStart(StartContext ctx) {
		logger.trace("Visiting Start: {}", ctx.getText());
		variableStack.clear();
		List<Assignment> assignments = ctx.set().stream().map(s-> ((AssignmentNodeImpl)visit(s)).getAssignment()).toList();
		Condition condition = ((ConditionNodeImpl)visit(ctx.conditiongroup())).getCondition();
		Execution execution = new ExecutionImpl(assignments, condition);
		return new ExecutionNodeImpl(execution);
	}
	
	@Override
	public ConditionNodeImpl visitLOGICALGRPT(LOGICALGRPTContext ctx) {
		logger.trace("Visiting LOGICALGRP: {}", ctx.getText());
		String op = ctx.logicalop().getText();
		Condition left = ((ConditionNodeImpl)visit(ctx.conditiongroup(0))).getCondition();
		Condition right = ((ConditionNodeImpl)visit(ctx.conditiongroup(1))).getCondition();
		Condition condition = new LogicConditionImpl(LogicOp.fromSymbol(op), left, right);
		return new ConditionNodeImpl(condition);
	}

	@Override
	public ConditionNodeImpl visitBINARYGRP(BINARYGRPContext ctx) {
		logger.trace("Visiting BINARYGRP: {}", ctx.getText());
		String sign = ctx.binarysign().getText();
		ConditionNodeImpl node = (ConditionNodeImpl)visit(ctx.conditiongroup());
		SignConditionImpl condition = new SignConditionImpl(BinarySign.fromSymbol(sign), node.getCondition());
		return new ConditionNodeImpl(condition);
	}
	
	@Override
	public Node visitRELOPGRP(RELOPGRPContext ctx) {
		logger.trace("Visiting RELOPGRP: {}", ctx.getText());
		String op = ctx.relop().getText();
		Expression l = ((ExpressionNodeImpl)visit(ctx.expr(0))).getExpression();
		Expression r = ((ExpressionNodeImpl)visit(ctx.expr(1))).getExpression();
		Condition condition = new ConditionImpl(BinaryOp.fromSymbol(op), l, r);
		return new ConditionNodeImpl(condition);
	}

	@Override
	public Node visitSIGNGRP(SIGNGRPContext ctx) {
		logger.trace("Visiting SIGNGRP: {}", ctx.getText());
		String sign = ctx.arithmeticsign().getText();
		ExpressionNodeImpl node = (ExpressionNodeImpl)visit(ctx.expr());
		SignExpressionImpl signNode = new SignExpressionImpl(ArithmeticSign.fromSymbol(sign), node.getExpression());
		return new ExpressionNodeImpl(signNode);
	}
	
	@Override
	public Node visitMULOPGRP(MULOPGRPContext ctx) {
		logger.trace("Visiting MULOPGRP: {}", ctx.getText());
		String op = ctx.mulop().getText();
		return createConditionNode(op, ctx.expr(0), ctx.expr(1));
	}
	
	@Override
	public Node visitADDOPGRP(ADDOPGRPContext ctx) {
		logger.trace("Visiting ADDOPGRP: {}", ctx.getText());
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
		logger.trace("Visiting DOUBLE: {}", ctx.getText());
		Double d = Double.valueOf(ctx.DOUBLE().getText());
		NumberImpl numberNode = new NumberImpl(d);
		return new ExpressionNodeImpl(numberNode);
	}

	@Override
	public ExpressionNodeImpl visitVARIABLE(VARIABLEContext ctx) {
		logger.trace("Visiting VARIABLE: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		variableStack.addExpressionVariable(variable);
		VariableImpl variableNode = new VariableImpl(variable);
		return new ExpressionNodeImpl(variableNode);
	}

	@Override
	public AssignmentNodeImpl visitASSSIGNMENT(ASSSIGNMENTContext ctx) {
		logger.trace("Visiting ASSSIGNMENT: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		ExpressionNodeImpl experssionNode = (ExpressionNodeImpl)visit(ctx.expr());
		Expression expression = experssionNode.getExpression();
		variableStack.addAssignmentVariable(variable);
		AssignmentImpl assignment = new AssignmentImpl(variable, expression);
		return new AssignmentNodeImpl(assignment);
	}

}
