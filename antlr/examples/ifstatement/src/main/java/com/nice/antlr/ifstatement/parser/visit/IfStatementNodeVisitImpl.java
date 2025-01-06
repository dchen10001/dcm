package com.nice.antlr.ifstatement.parser.visit;

import java.util.List;

import com.nice.antlr.ifstatement.node.action.DoAction;
import com.nice.antlr.ifstatement.node.assignment.ConditionAssignmentImpl;
import com.nice.antlr.ifstatement.node.assignment.ExpressionAssignmentImpl;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatement;
import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatementImpl;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatementImpl;
import com.nice.antlr.ifstatement.parser.IfStatementParser.CNDASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.EXPRASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElseifstmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ElsestmtContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.IfstmtContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ActionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ConditionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ElseIfStatementWarrperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExpressionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;

public abstract class IfStatementNodeVisitImpl extends ConditionNodeVisitImpl {
	
	@Override
	public IfStatementWrapperImpl visitIfstmt(IfstmtContext ctx) {
		logger.trace("Visiting IFSTMT: {}", ctx.getText());
		Condition condition = ((ConditionWrapperImpl)visit(ctx.conditiongroup())).getCondition();
		DoAction action = ((ActionWrapperImpl)visit(ctx.doRule())).getAction();
		DoAction elseAction = ((ActionWrapperImpl)visit(ctx.elsestmt())).getAction();
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
		ActionWrapperImpl actionNode = (ActionWrapperImpl)visit(ctx.doRule());
		ElseIfStatement elseIfStatement = new ElseIfStatementImpl(conditionNode.getCondition(), actionNode.getAction());
		return new ElseIfStatementWarrperImpl(elseIfStatement);
	}

	@Override
	public ActionWrapperImpl visitElsestmt(ElsestmtContext ctx) {
		logger.trace("Visiting ELSESTMT: {}", ctx.getText());
		return (ActionWrapperImpl)visit(ctx.doRule());
	}
	
	@Override
	public AssignmentWrapperImpl visitEXPRASSSIGNMENT(EXPRASSSIGNMENTContext ctx) {
		logger.trace("Visiting EXPRASSSIGNMENT: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		
		variableStack.addAssignmentVariable(variable, Double.class);
		ExpressionWrapperImpl experssionNode = (ExpressionWrapperImpl) visit(ctx.expr());
		Expression expression = experssionNode.getExpression();
		
		ExpressionAssignmentImpl assignment = new ExpressionAssignmentImpl(variable, expression);
		return new AssignmentWrapperImpl(assignment);
	}

	@Override
	public AssignmentWrapperImpl visitCNDASSSIGNMENT(CNDASSSIGNMENTContext ctx) {
		logger.trace("Visiting CNDASSSIGNMENT: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		variableStack.addAssignmentVariable(variable, Boolean.class);
		
		ConditionWrapperImpl conditionNode = (ConditionWrapperImpl) visit(ctx.conditiongroup());
		Condition condition = conditionNode.getCondition();
		ConditionAssignmentImpl assignment = new ConditionAssignmentImpl(variable, condition);
		return new AssignmentWrapperImpl(assignment);
	}
}
