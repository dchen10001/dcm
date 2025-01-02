package com.nice.antlr.ifstatement.parser.visit;

import java.util.ArrayList;
import java.util.List;

import com.nice.antlr.ifstatement.node.Execution;
import com.nice.antlr.ifstatement.node.ExecutionImpl;
import com.nice.antlr.ifstatement.node.action.Action;
import com.nice.antlr.ifstatement.node.action.PrintActionImpl;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.assignment.ConditionAssignmentImpl;
import com.nice.antlr.ifstatement.node.assignment.ExpressionAssignmentImpl;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatement;
import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatementImpl;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatementImpl;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ConditiongroupContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElseifstmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElsestmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ExprContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.IfstmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.PRINTDOUBLEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.SetdoubleContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.StartContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ActionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ConditionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ElseIfStatementWarrperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExecutionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExpressionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;

public class ScriptNodeVisitorImpl extends ConditionNodeVisitImpl {

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
	public IfStatementWrapperImpl visitIfstmt(IfstmtContext ctx) {
		logger.trace("Visiting IFSTMT: {}", ctx.getText());
		Condition condition = ((ConditionWrapperImpl)visit(ctx.conditiongroup())).getCondition();
		Action action = ((ActionWrapperImpl)visit(ctx.printstmt())).getAction();
		Action elseAction = ((ActionWrapperImpl)visit(ctx.elsestmt())).getAction();
		List<ElseIfStatement> elseIfStatements = ctx.elseifstmt().stream().map(this::toElseIfStatement).toList();
		IfStatement ifStatement = new IfStatementImpl(condition, action, elseAction, elseIfStatements);
		return new IfStatementWrapperImpl(ifStatement);
	}

	public ElseIfStatement toElseIfStatement(ElseifstmtContext ctx) {
		return ((ElseIfStatementWarrperImpl)visit(ctx)).getElseIfStatement();
	}
	
	@Override
	public ElseIfStatementWarrperImpl visitElseifstmt(ElseifstmtContext ctx) {
		logger.trace("Visiting ELSEIFSTMT: {}",	ctx.getText());
		ConditionWrapperImpl conditionNode = (ConditionWrapperImpl)visit(ctx.conditiongroup());
		ActionWrapperImpl actionNode = (ActionWrapperImpl)visit(ctx.printstmt());
		ElseIfStatement elseIfStatement = new ElseIfStatementImpl(conditionNode.getCondition(), actionNode.getAction());
		return new ElseIfStatementWarrperImpl(elseIfStatement);
	}

	@Override
	public ActionWrapperImpl visitElsestmt(ElsestmtContext ctx) {
		logger.trace("Visiting ELSESTMT: {}", ctx.getText());
		return (ActionWrapperImpl)visit(ctx.printstmt());
	}

	@Override
	public ActionWrapperImpl visitPRINTDOUBLE(PRINTDOUBLEContext ctx) {
		logger.trace("Visiting PRINTSTMT: {}", ctx.getText());
		double d = Double.parseDouble(ctx.DOUBLE().getText());
		return new ActionWrapperImpl(new PrintActionImpl(d));
	}
}
