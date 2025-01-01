package com.nice.antlr.function.parser.visit;

import com.nice.antlr.condition.parser.ConditionParser.AddopContext;
import com.nice.antlr.condition.parser.ConditionParser.ArithmeticsignContext;
import com.nice.antlr.condition.parser.ConditionParser.BinarysignContext;
import com.nice.antlr.condition.parser.ConditionParser.CNDPARENGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.CONDITIONGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.CONDITIONGRPTContext;
import com.nice.antlr.condition.parser.ConditionParser.EXPPARENGRPContext;
import com.nice.antlr.condition.parser.ConditionParser.LogicalopContext;
import com.nice.antlr.condition.parser.ConditionParser.MulopContext;
import com.nice.antlr.condition.parser.ConditionParser.RelopContext;
import com.nice.antlr.function.parser.visit.nodewrapper.NodeWrapper;

public abstract class AbstractNodeVisitorImpl extends CommonNodeVisitorImpl {
	@Override
	public NodeWrapper<?> visitCONDITIONGRPT(CONDITIONGRPTContext ctx) {
		logger.trace("Visiting CONDITIONGRPT: {}", ctx.getText());
		return visit(ctx.conditiongroup());
	}
	
	@Override
	public NodeWrapper<?> visitCONDITIONGRP(CONDITIONGRPContext ctx) {
		logger.trace("Visiting CONDITIONGRP: {}", ctx.getText());
		return visit(ctx.condition());
	}
	
	@Override
	public NodeWrapper<?> visitCNDPARENGRP(CNDPARENGRPContext ctx) {
		logger.trace("Visiting CNDPARENGRP: {}", ctx.getText());
		return visit(ctx.condition());
	}
	
	@Override
	public NodeWrapper<?> visitEXPPARENGRP(EXPPARENGRPContext ctx) {
		logger.trace("Visiting PARENGRP: {}", ctx.getText());
		return visit(ctx.expr());
	}
	
	@Override
	public NodeWrapper<?> visitAddop(AddopContext ctx) {
		logger.trace("Visiting Addop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public NodeWrapper<?> visitMulop(MulopContext ctx) {
		logger.trace("Visiting Mulop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public NodeWrapper<?> visitRelop(RelopContext ctx) {
		logger.trace("Visiting Relop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public NodeWrapper<?> visitArithmeticsign(ArithmeticsignContext ctx) {
		logger.trace("Visiting Arithmeticsign: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public NodeWrapper<?> visitBinarysign(BinarysignContext ctx) {
		logger.trace("Visiting Binarysign: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public NodeWrapper<?> visitLogicalop(LogicalopContext ctx) {
		logger.trace("Visiting Logicalop: {}", ctx.getText());
		return visitChildren(ctx);
	}
}
