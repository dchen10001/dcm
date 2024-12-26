package com.nice.antlr.function.parser.node;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.nice.antlr.condition.parser.ConditionVisitor;

public abstract class AbstractNodeVisitorImpl implements ConditionVisitor<Node> {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractNodeVisitorImpl.class);

	@Override
	public Node visit(ParseTree tree) {
		logger.debug("Visiting tree: {}", tree.getText());
		return tree.accept(this);
	}

	@Override
	public Node visitTerminal(TerminalNode node) {
		logger.debug("Visiting terminal: {}", node.getText());
		return defaultResult();
	}

	@Override
	public Node visitErrorNode(ErrorNode node) {
		logger.debug("Visiting error node: {}", node.getText());
		return defaultResult();
	}

	@Override
	public Node visitCONDITIONGRPT(CONDITIONGRPTContext ctx) {
		logger.debug("Visiting CONDITIONGRPT: {}", ctx.getText());
		return visit(ctx.conditiongroup());
	}
	
	@Override
	public Node visitCONDITIONGRP(CONDITIONGRPContext ctx) {
		logger.debug("Visiting CONDITIONGRP: {}", ctx.getText());
		return visit(ctx.condition());
	}
	
	@Override
	public Node visitCNDPARENGRP(CNDPARENGRPContext ctx) {
		logger.debug("Visiting CNDPARENGRP: {}", ctx.getText());
		return visit(ctx.condition());
	}
	
	@Override
	public Node visitEXPPARENGRP(EXPPARENGRPContext ctx) {
		logger.debug("Visiting PARENGRP: {}", ctx.getText());
		return visit(ctx.expr());
	}
	
	@Override
	public Node visitAddop(AddopContext ctx) {
		logger.debug("Visiting Addop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public Node visitMulop(MulopContext ctx) {
		logger.debug("Visiting Mulop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public Node visitRelop(RelopContext ctx) {
		logger.debug("Visiting Relop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public Node visitArithmeticsign(ArithmeticsignContext ctx) {
		logger.debug("Visiting Arithmeticsign: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public Node visitBinarysign(BinarysignContext ctx) {
		logger.debug("Visiting Binarysign: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public Node visitLogicalop(LogicalopContext ctx) {
		logger.debug("Visiting Logicalop: {}", ctx.getText());
		return visitChildren(ctx);
	}
	
	protected Node defaultResult() {
		return null;
	}
	
	protected boolean shouldVisitNextChild(RuleNode node, Node currentResult) {
		return true;
	}
	
	protected Node aggregateResult(Node aggregate, Node nextResult) {
		return nextResult;
	}
	
	@Override
	public Node visitChildren(RuleNode node) {
		logger.debug("Visiting children: {}", node.getText());
		Node result = defaultResult();
		int n = node.getChildCount();
		for (int i=0; i<n; i++) {
			if (!shouldVisitNextChild(node, result)) {
				break;
			}

			ParseTree c = node.getChild(i);
			Node childResult = c.accept(this);
			result = aggregateResult(result, childResult);
		}
		return result;
	}
}
