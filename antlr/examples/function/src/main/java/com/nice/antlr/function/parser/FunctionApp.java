package com.nice.antlr.function.parser;

import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.function.parser.listener.ThrowingErrorListener;
import com.nice.antlr.function.parser.node.FunctionNode;
import com.nice.antlr.function.parser.node.FunctionNodeVisitorImpl;
import com.nice.antlr.function.parser.runtime.FunctionVisitorImpl;

public class FunctionApp {
	private static final Logger logger = LoggerFactory.getLogger(FunctionApp.class);

	public static void main(String[] args) {
		String arg = args.length > 0 ? args[0] : " -((a + 1) * 2 + 1 * b - c / d) ";
		Map<String, Double> variables = Map.of("a", 1.0, "b", 2.0, "c", 3.0, "d", 4.0);

		
		FunctionApp calculator = new FunctionApp();
		
		String arithmeticExpression = " a + (b + 1) * (c + 2) / (d + 3)";
		
		FunctionNode node = calculator.parse(arithmeticExpression);
		
        Double result = calculator.calculate(arg, variables);

        logger.info(String.format("%s = %s", arg, result));
	}

	public FunctionNode parse(String arithmeticExpression) {
		logger.debug("expression: {}", arithmeticExpression);
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		FunctionLexer lexer = new FunctionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FunctionParser parser = new FunctionParser(tokens);
		ParseTree tree = parser.start();
		FunctionNodeVisitorImpl visitor = new FunctionNodeVisitorImpl();
		return visitor.visit(tree);
	}
	
	
	public Double calculate(String arithmeticExpression, Map<String, Double> variables) {
		logger.debug("expression: {}", arithmeticExpression);
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		return compile(input, variables);
	}
	
    private Double compile(CharStream input, Map<String, Double> variables) {
    	FunctionLexer lexer = new FunctionLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);
    	
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	FunctionParser parser = new FunctionParser(tokens);
        parser.addErrorListener(errorListener);
        FunctionVisitorImpl vistor = new FunctionVisitorImpl();
		for (Map.Entry<String, Double> entry : variables.entrySet()) {
			vistor.setVariable(entry.getKey(), entry.getValue());
		}
        ParseTree tree = parser.start();
        return vistor.visit(tree);
    }	
}
