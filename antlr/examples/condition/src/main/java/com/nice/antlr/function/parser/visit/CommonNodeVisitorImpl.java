package com.nice.antlr.function.parser.visit;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.condition.parser.ConditionVisitor;
import com.nice.antlr.function.parser.visit.nodewrapper.NodeWrapper;

public abstract class CommonNodeVisitorImpl implements ConditionVisitor<NodeWrapper<?>> {
	protected static final Logger logger = LoggerFactory.getLogger(CommonNodeVisitorImpl.class);

	@Override
	public NodeWrapper<?> visit(ParseTree tree) {
		logger.trace("Visiting tree: {}", tree.getText());
		return tree.accept(this);
	}

	@Override
	public NodeWrapper<?> visitChildren(RuleNode node) {
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
	public NodeWrapper<?> visitTerminal(TerminalNode node) {
		logger.trace("Visiting terminal: {}", node.getText());
		return defaultResult();
	}

	@Override
	public NodeWrapper<?> visitErrorNode(ErrorNode node) {
		logger.trace("Visiting error node: {}", node.getText());
		return defaultResult();
	}

	@SuppressWarnings("rawtypes")
	protected NodeWrapper defaultResult() {
		return null;
	}
	
	protected boolean shouldVisitNextChild(RuleNode node, NodeWrapper<?> currentResult) {
		logger.trace("shouldVisitNextChild node: {}, currentResult: {} ", node.getText(), currentResult);
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	protected NodeWrapper aggregateResult(NodeWrapper<?> aggregate, NodeWrapper<?> nextResult) {
		logger.trace("aggregateResult node. aggregate : {}, nextResult : {}", aggregate, nextResult);
		return nextResult;
	}
}
