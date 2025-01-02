package com.nice.antlr.ifstatement.parser.visit;

import java.util.List;
import java.util.Map;

import com.nice.antlr.ifstatement.node.variable.NodeVariableStack;
import com.nice.antlr.ifstatement.node.variable.NodeVariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementParser.AddopContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ArithmeticsignContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.BinarysignContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.CNDPARENGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.CONDITIONGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.CONDITIONGRPTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.EXPPARENGRPContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.LogicalopContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.MulopContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.RelopContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.NodeWrapper;

public abstract class AbstractNodeVisitorImpl extends CommonNodeVisitorImpl {
	protected NodeVariableStack variableStack = new NodeVariableStackImpl();

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