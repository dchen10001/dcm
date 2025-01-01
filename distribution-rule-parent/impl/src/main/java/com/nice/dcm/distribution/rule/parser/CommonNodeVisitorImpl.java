package com.nice.dcm.distribution.rule.parser;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.distribution.rule.parser.node.Node;

import lombok.NonNull;

public abstract class CommonNodeVisitorImpl implements RuleVistor {
	protected static final Logger logger = LoggerFactory.getLogger(CommonNodeVisitorImpl.class);

	@Override
	public Node visit(@NonNull ParseTree tree) {
		logger.trace("Visiting tree: {}", tree.getText());
		return tree.accept(this);
	}

	@Override
	public Node visitChildren(@NonNull RuleNode node) {
		logger.trace("Visiting children: {}", node.getText());
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

	@Override
	public Node visitTerminal(@NonNull TerminalNode node) {
		logger.trace("Visiting terminal: {}", node.getText());
		return defaultResult();
	}

	@Override
	public Node visitErrorNode(@NonNull ErrorNode node) {
		logger.trace("Visiting error node: {}", node.getText());
		return defaultResult();
	}

	protected Node defaultResult() {
		return null;
	}
	
	protected boolean shouldVisitNextChild(RuleNode node, Node currentResult) {
		logger.trace("shouldVisitNextChild node: {}, currentResult: {} ", node.getText(), currentResult);
		return true;
	}
	
	protected Node aggregateResult(Node aggregate, Node nextResult) {
		logger.trace("aggregateResult node. aggregate : {}, nextResult : {}", aggregate, nextResult);
		return nextResult;
	}
}
