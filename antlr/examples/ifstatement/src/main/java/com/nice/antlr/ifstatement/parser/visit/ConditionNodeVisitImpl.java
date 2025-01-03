package com.nice.antlr.ifstatement.parser.visit;

import com.nice.antlr.ifstatement.node.condition.BooleanConstantImpl;
import com.nice.antlr.ifstatement.node.condition.BooleanVariableImpl;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.condition.ConditionImpl;
import com.nice.antlr.ifstatement.node.condition.LogicConditionImpl;
import com.nice.antlr.ifstatement.node.condition.SignConditionImpl;
import com.nice.antlr.ifstatement.node.expression.Expression;
import com.nice.antlr.ifstatement.node.operator.BinaryOp;
import com.nice.antlr.ifstatement.node.operator.BinarySign;
import com.nice.antlr.ifstatement.node.operator.LogicOp;
import com.nice.antlr.ifstatement.parser.IfStatementParser.BINARYGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.BOOLEANContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.LOGICALGRPTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.RELOPGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.VARIABLEGRPContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ConditionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExpressionWrapperImpl;

public abstract class ConditionNodeVisitImpl extends ExpressionNodeVisitorImpl {
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
	public ConditionWrapperImpl visitBOOLEAN(BOOLEANContext ctx) {
		logger.trace("Visiting BOOLEAN: {}", ctx.getText());
		Condition condition = new BooleanConstantImpl("true".equals(ctx.getText()));
		return new ConditionWrapperImpl(condition);
	}
}
