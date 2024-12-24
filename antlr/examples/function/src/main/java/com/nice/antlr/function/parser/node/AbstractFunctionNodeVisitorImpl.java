package com.nice.antlr.function.parser.node;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.function.parser.FunctionVisitor;
import com.nice.antlr.function.parser.FunctionParser.AddopContext;
import com.nice.antlr.function.parser.FunctionParser.MulopContext;
import com.nice.antlr.function.parser.FunctionParser.PARENGRPContext;

public abstract class AbstractFunctionNodeVisitorImpl implements FunctionVisitor<FunctionNode> {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractFunctionNodeVisitorImpl.class);

	@Override
	public FunctionNode visit(ParseTree tree) {
		logger.debug("Visiting tree: {}", tree.getText());
		return tree.accept(this);
	}

	@Override
	public FunctionNode visitTerminal(TerminalNode node) {
		logger.debug("Visiting terminal: {}", node.getText());
		return defaultResult();
	}

	@Override
	public FunctionNode visitErrorNode(ErrorNode node) {
		logger.debug("Visiting error node: {}", node.getText());
		return defaultResult();
	}

	@Override
	public FunctionNode visitPARENGRP(PARENGRPContext ctx) {
		logger.debug("Visiting PARENGRP: {}", ctx.getText());
		return visit(ctx.expr());
	}
	
	@Override
	public FunctionNode visitAddop(AddopContext ctx) {
		logger.debug("Visiting Addop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public FunctionNode visitMulop(MulopContext ctx) {
		logger.debug("Visiting Mulop: {}", ctx.getText());
		return visitChildren(ctx);
	}

	protected FunctionNode defaultResult() {
		return null;
	}
	
	protected boolean shouldVisitNextChild(RuleNode node, FunctionNode currentResult) {
		return true;
	}
	
	protected FunctionNode aggregateResult(FunctionNode aggregate, FunctionNode nextResult) {
		return nextResult;
	}
	
	@Override
	public FunctionNode visitChildren(RuleNode node) {
		logger.debug("Visiting children: {}", node.getText());
		FunctionNode result = defaultResult();
		int n = node.getChildCount();
		for (int i=0; i<n; i++) {
			if (!shouldVisitNextChild(node, result)) {
				break;
			}

			ParseTree c = node.getChild(i);
			FunctionNode childResult = c.accept(this);
			result = aggregateResult(result, childResult);
		}
		return result;
	}
}
