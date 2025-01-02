package com.nice.antlr.ifstatement.parser.node1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nice.antlr.ifstatement.node.Execution;
import com.nice.antlr.ifstatement.node.ExecutionImpl;
import com.nice.antlr.ifstatement.node.action.PrintActionImpl;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.assignment.ConditionAssignmentImpl;
import com.nice.antlr.ifstatement.node.assignment.ExpressionAssignmentImpl;
import com.nice.antlr.ifstatement.node.condition.BooleanVariableImpl;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.condition.ConditionImpl;
import com.nice.antlr.ifstatement.node.condition.LogicConditionImpl;
import com.nice.antlr.ifstatement.node.condition.SignConditionImpl;
import com.nice.antlr.ifstatement.node.expression.DoubleConstantImpl;
import com.nice.antlr.ifstatement.node.expression.DoubleVariableImpl;
import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.expression.ExpressionImpl;
import com.nice.antlr.ifstatement.node.expression.SignExpressionImpl;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.operator.ArithmeticOp;
import com.nice.antlr.ifstatement.node.operator.ArithmeticSign;
import com.nice.antlr.ifstatement.node.operator.BinaryOp;
import com.nice.antlr.ifstatement.node.operator.BinarySign;
import com.nice.antlr.ifstatement.node.operator.LogicOp;
import com.nice.antlr.ifstatement.node.variable.NodeVariableStack;
import com.nice.antlr.ifstatement.node.variable.NodeVariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ADDOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.BINARYGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ConditiongroupContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.DOUBLEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElseifstmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElsestmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ExprContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.IfstmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.LOGICALGRPTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.MULOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.PRINTSTMTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.RELOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.SIGNGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.SetdoubleContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.StartContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.VARIABLEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.VARIABLEGRPContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ActionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ConditionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExecutionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExpressionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.NodeWrapper;

public class ScriptNodeVisitorImpl extends AbstractNodeVisitorImpl {

	private NodeVariableStack variableStack = new NodeVariableStackImpl();

	public void reset() {
		this.variableStack.clear();
	}
	
	public List<String> getVariableNames(Class<?> type) {
		return variableStack.getVariables().entrySet()
		.stream().filter(e -> e.getValue().equals(type))
		.map(Map.Entry::getKey)
		.toList();
	}
	
	public List<String> getAssignmentNames(Class<?> type) {
		return variableStack.getAssignments().entrySet()
		.stream().filter(e -> e.getValue().equals(type))
		.map(Map.Entry::getKey)
		.toList();
	}
	
	@Override
	public ExecutionWrapperImpl visitStart(StartContext ctx) {
		logger.trace("Visiting Start: {}", ctx.getText());
		reset();
		List<Assignment<?>> assignments = new ArrayList<>();
		for(SetdoubleContext setdoubleCtx : ctx.setdouble()) {
			AssignmentWrapperImpl node = (AssignmentWrapperImpl)visit(setdoubleCtx);
			assignments.add(node.getAssignment());
		}

		IfStatement ifStatement = ((IfStatementWrapperImpl)visit(ctx.ifstmt())).getIfStatement();
		
		Execution execution = new ExecutionImpl(assignments, ifStatement);
		return new ExecutionWrapperImpl(execution);
	}
	
	@Override
	public ConditionWrapperImpl visitLOGICALGRPT(LOGICALGRPTContext ctx) {
		logger.trace("Visiting LOGICALGRP: {}", ctx.getText());
		String op = ctx.logicalop().getText();
		Condition left = ((ConditionWrapperImpl)visit(ctx.conditiongroup(0))).getCondition();
		Condition right = ((ConditionWrapperImpl)visit(ctx.conditiongroup(1))).getCondition();
		Condition condition = new LogicConditionImpl(LogicOp.fromSymbol(op), left, right);
		return new ConditionWrapperImpl(condition);
	}


	@Override
	public ConditionWrapperImpl visitVARIABLEGRP(VARIABLEGRPContext ctx) {
		logger.trace("Visiting VARIABLEGRP: {}", ctx.getText());
		String booleanVariable = ctx.Identifier().getText();
		variableStack.addParameterVariable(booleanVariable, Boolean.class);
		Condition condition = new BooleanVariableImpl(booleanVariable);
		return new ConditionWrapperImpl(condition);
	}
	
	@Override
	public ConditionWrapperImpl visitBINARYGRP(BINARYGRPContext ctx) {
		logger.trace("Visiting BINARYGRP: {}", ctx.getText());
		String sign = ctx.binarysign().getText();
		ConditionWrapperImpl node = (ConditionWrapperImpl)visit(ctx.conditiongroup());
		SignConditionImpl condition = new SignConditionImpl(BinarySign.fromSymbol(sign), node.getCondition());
		return new ConditionWrapperImpl(condition);
	}
	
	@Override
	public ConditionWrapperImpl visitRELOPGRP(RELOPGRPContext ctx) {
		logger.trace("Visiting RELOPGRP: {}", ctx.getText());
		String op = ctx.relop().getText();
		Expression l = ((ExpressionWrapperImpl)visit(ctx.expr(0))).getExpression();
		Expression r = ((ExpressionWrapperImpl)visit(ctx.expr(1))).getExpression();
		Condition condition = new ConditionImpl(BinaryOp.fromSymbol(op), l, r);
		return new ConditionWrapperImpl(condition);
	}

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

	@Override
	public AssignmentWrapperImpl visitASSSIGNMENT(ASSSIGNMENTContext ctx) {
		logger.trace("Visiting DOUBLE ASSSIGNMENT: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		
		ExprContext exprCtx = ctx.expr();
		if (exprCtx != null) {
			return visitExprContext(variable, exprCtx);
		}
		
		ConditiongroupContext cndCtx = ctx.conditiongroup();
		if (cndCtx != null) {
			return visitConditiongroupContext(variable,  cndCtx);
		}
		return null;
	}
	
	private AssignmentWrapperImpl visitConditiongroupContext(String variable,  ConditiongroupContext cndCtx) {
		variableStack.addAssignmentVariable(variable, Boolean.class);
		ConditionWrapperImpl conditionNode = (ConditionWrapperImpl) visit(cndCtx);
		Condition condition = conditionNode.getCondition();
		ConditionAssignmentImpl assignment = new ConditionAssignmentImpl(variable, condition);
		return new AssignmentWrapperImpl(assignment);
	}

	private AssignmentWrapperImpl visitExprContext(String variable,  ExprContext exprCtx) {
		ExpressionWrapperImpl experssionNode = (ExpressionWrapperImpl) visit(exprCtx);
		Expression expression = experssionNode.getExpression();
		variableStack.addAssignmentVariable(variable, Double.class);
		ExpressionAssignmentImpl assignment = new ExpressionAssignmentImpl(variable, expression);
		return new AssignmentWrapperImpl(assignment);
	}

	@Override
	public NodeWrapper<?> visitElseifstmt(ElseifstmtContext ctx) {
		logger.trace("Visiting ELSEIFSTMT: {}",	ctx.getText());
		ConditionWrapperImpl conditionNode = (ConditionWrapperImpl)visit(ctx.conditiongroup());
		ActionWrapperImpl actionNode = (ActionWrapperImpl)visit(ctx.printstmt());
		return null;
	}

	@Override
	public ActionWrapperImpl visitElsestmt(ElsestmtContext ctx) {
		logger.trace("Visiting ELSESTMT: {}", ctx.getText());
		return (ActionWrapperImpl)visit(ctx.printstmt());
	}

	@Override
	public NodeWrapper<?> visitIfstmt(IfstmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionWrapperImpl visitPRINTSTMT(PRINTSTMTContext ctx) {
		logger.trace("Visiting PRINTSTMT: {}", ctx.getText());
		double d = Double.valueOf(ctx.DOUBLE().getText());
		return new ActionWrapperImpl(new PrintActionImpl(d));
	}
}
