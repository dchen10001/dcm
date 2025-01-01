package com.nice.antlr.function.parser;

import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.condition.parser.ConditionLexer;
import com.nice.antlr.condition.parser.ConditionParser;
import com.nice.antlr.function.parser.visit.ScriptNodeVisitorImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.NodeWrapper;

public class ConditionApp {
	private static final Logger logger = LoggerFactory.getLogger(ConditionApp.class);

	public static void main(String[] args) {
		String arg = args.length > 0 ? args[0] : " -((a + 1) * 2 + 1 * b - c / d) ";
		Map<String, Double> variables = Map.of("a", 1.0, "b", 2.0, "c", 3.0, "d", 4.0);

		
		ConditionApp calculator = new ConditionApp();
		
		String arithmeticExpression = " a + (b + 1) * (c + 2) / (d + 3)";
		
		NodeWrapper node = calculator.parse(arithmeticExpression);

        logger.info(String.format("%s = %s", arg, node));
	}

	public NodeWrapper parse(String arithmeticExpression) {
		logger.debug("expression: {}", arithmeticExpression);
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		ConditionLexer lexer = new ConditionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ConditionParser parser = new ConditionParser(tokens);
		ParseTree tree = parser.start();
		ScriptNodeVisitorImpl visitor = new ScriptNodeVisitorImpl();
		return visitor.visit(tree);
	}
}
