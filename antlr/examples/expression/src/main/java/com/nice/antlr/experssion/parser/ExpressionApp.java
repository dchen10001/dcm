package com.nice.antlr.experssion.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.experssion.parser.listener.ThrowingErrorListener;

public class ExpressionApp {
	private static final Logger logger = LoggerFactory.getLogger(ExpressionApp.class);

	public static void main(String[] args) {
		String arg = args.length > 0 ? args[0] : " 1 + 1 * 2 - 3 / 4 ";

		ExpressionApp calculator = new ExpressionApp();
        Double result = calculator.calculate(arg);

        logger.info(String.format("%s = %s", arg, result));
	}

	public Double calculate(String arithmeticExpression) {
		logger.debug("expression: {}", arithmeticExpression);
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		return compile(input);
	}
	
    private Double compile(CharStream input) {
    	ExpressionLexer lexer = new ExpressionLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);
    	
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	ExpressionParser parser = new ExpressionParser(tokens);
        parser.addErrorListener(errorListener);
        ExpressionVisitorImpl vistor = new ExpressionVisitorImpl();
        ParseTree tree = parser.start();
        return vistor.visit(tree);
    }	
}
