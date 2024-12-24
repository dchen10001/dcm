package com.nice.antlr.function.parser.node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import com.nice.antlr.function.node.ExpressionNode;
import com.nice.antlr.function.node.VariableStack;
import com.nice.antlr.function.node.VariableStackImpl;
import com.nice.antlr.function.parser.FunctionLexer;
import com.nice.antlr.function.parser.FunctionParser;
import com.nice.antlr.function.parser.listener.ThrowingErrorListener;
import com.nice.antlr.function.parser.runtime.FunctionVisitorImpl;

class PerformanceTest {
	@Test
	void testFunctionNodeVisitorImpl() {
		String arithmeticExpression= " a + ((b + 1.0) * (c + 2.0)) / (d + 3.0)";
		long start = System.currentTimeMillis();
		FunctionNodeVisitorImpl visitor = new FunctionNodeVisitorImpl();
		ExpressionNode node = parse(arithmeticExpression, visitor);
		for (int i = 0; i < 100; i++) {
			double a = 1.0;
			double b = 2.0;
			double c = 3.0;
			double d = 4.0;
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", a);
			variableStack.setVariable("b", b);
			variableStack.setVariable("c", c);
			variableStack.setVariable("d", d);
			double result = node.eval(variableStack);
			System.out.println("result: " + result);
		}
		long end = System.currentTimeMillis();
		System.out.println("FunctionNodeVisitorImpl Time: " + (end - start));
	}

	@Test
	void testFunctionVisitorImpl() {
		String arithmeticExpression= " a + ((b + 1.0) * (c + 2.0)) / (d + 3.0)";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			double a = 1.0;
			double b = 2.0;
			double c = 3.0;
			double d = 4.0;
			Map<String, Double> variables = Map.of("a", a, "b", b, "c", c, "d", d);
			Double result = calculate(arithmeticExpression, variables);
			System.out.println("result: " + result);
		}
		long end = System.currentTimeMillis();
		System.out.println("FunctionVisitorImpl Time: " + (end - start));
	}
	
	public Double calculate(String arithmeticExpression, Map<String, Double> variables) {
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
    
	public ExpressionNode parse(String arithmeticExpression, FunctionNodeVisitorImpl visitor) {
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		FunctionLexer lexer = new FunctionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FunctionParser parser = new FunctionParser(tokens);
		ParseTree tree = parser.start();
		return visitor.visit(tree).getExpression();
	}
}
