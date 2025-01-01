package com.nice.antlr.function.parser.visit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nice.antlr.condition.parser.ConditionParser.ADDOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.ASSSIGNMENTContext;
import com.nice.antlr.condition.parser.ConditionParser.BINARYGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.ConditiongroupContext;
import com.nice.antlr.condition.parser.ConditionParser.DOUBLEContext;
import com.nice.antlr.condition.parser.ConditionParser.ExprContext;
import com.nice.antlr.condition.parser.ConditionParser.LOGICALGRPTContext;
import com.nice.antlr.condition.parser.ConditionParser.MULOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.RELOPGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.SIGNGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.SetdoubleContext;
import com.nice.antlr.condition.parser.ConditionParser.StartContext;
import com.nice.antlr.condition.parser.ConditionParser.VARIABLEContext;
import com.nice.antlr.condition.parser.ConditionParser.VARIABLEGRPContext;
import com.nice.antlr.function.node.Execution;
import com.nice.antlr.function.node.ExecutionImpl;
import com.nice.antlr.function.node.assignment.Assignment;
import com.nice.antlr.function.node.assignment.ConditionAssignmentImpl;
import com.nice.antlr.function.node.assignment.ExpressionAssignmentImpl;
import com.nice.antlr.function.node.condition.BooleanVariableImpl;
import com.nice.antlr.function.node.condition.Condition;
import com.nice.antlr.function.node.condition.ConditionImpl;
import com.nice.antlr.function.node.condition.LogicConditionImpl;
import com.nice.antlr.function.node.condition.SignConditionImpl;
import com.nice.antlr.function.node.expression.DoubleConstantImpl;
import com.nice.antlr.function.node.expression.DoubleVariableImpl;
import com.nice.antlr.function.node.expression.Expression;
import com.nice.antlr.function.node.expression.ExpressionImpl;
import com.nice.antlr.function.node.expression.SignExpressionImpl;
import com.nice.antlr.function.node.operator.ArithmeticOp;
import com.nice.antlr.function.node.operator.ArithmeticSign;
import com.nice.antlr.function.node.operator.BinaryOp;
import com.nice.antlr.function.node.operator.BinarySign;
import com.nice.antlr.function.node.operator.LogicOp;
import com.nice.antlr.function.node.variable.NodeVariableStack;
import com.nice.antlr.function.node.variable.NodeVariableStackImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.ConditionWrapperImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.ExecutionWrapperImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.ExpressionWrapperImpl;

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
		Condition condition = ((ConditionWrapperImpl)visit(ctx.conditiongroup())).getCondition();
		Execution execution = new ExecutionImpl(assignments, condition);
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
}
