package com.nice.dcm.distribution.rule.parser.visitor;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;

import lombok.NonNull;

public abstract class CommonNodeVisitorImpl implements DCMDistributionRulesVisitor {
	protected static final Logger logger = LoggerFactory.getLogger(CommonNodeVisitorImpl.class);

	@Override
	public NodeWrapper<?> visit(@NonNull ParseTree tree) {
		logger.trace("Visiting tree: {}", tree.getText());
		return tree.accept(this);
	}

	@Override
	public NodeWrapper<?> visitChildren(@NonNull RuleNode node) {
		logger.trace("Visiting children: {}", node.getText());
		NodeWrapper<?> result = defaultResult();
		int n = node.getChildCount();
		for (int i=0; i<n; i++) {
			if (!shouldVisitNextChild(node, result)) {
				break;
			}

			ParseTree c = node.getChild(i);
			NodeWrapper<?> childResult = c.accept(this);
			result = aggregateResult(result, childResult);
		}
		return result;
	}

	@Override
	public NodeWrapper<?> visitTerminal(@NonNull TerminalNode node) {
		logger.trace("Visiting terminal: {}", node.getText());
		return defaultResult();
	}

	@Override
	public NodeWrapper<?> visitErrorNode(@NonNull ErrorNode node) {
		logger.trace("Visiting error node: {}", node.getText());
		return defaultResult();
	}

	protected NodeWrapper<?> defaultResult() {
		return null;
	}
	
	protected boolean shouldVisitNextChild(RuleNode node, NodeWrapper<?> currentResult) {
		logger.trace("shouldVisitNextChild node: {}, currentResult: {} ", node.getText(), currentResult);
		return true;
	}
	
	protected NodeWrapper<?> aggregateResult(NodeWrapper<?> aggregate, NodeWrapper<?> nextResult) {
		logger.trace("aggregateResult node. aggregate : {}, nextResult : {}", aggregate, nextResult);
		return nextResult;
	}
}
