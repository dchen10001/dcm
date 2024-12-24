package com.nice.antlr.function.parser.node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;

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

class FunctionNodeVisitorImplTest {
	String arithmeticExpressions[] = {" a + ((b + 1.0) * (c + 2.0)) / (d + 3.0)"
			, " -((a + 1.0) * 2.0 + 1.0 * b - c / d) "
			, " -(((a + 1.0) * (2.0 + 1.0)) * b - (c + 1.0) / (d - 100.1)) "
			, " -((a + 1.0) * 2.0 + 1.0 * b - (c / d) * 3.0) "
			, " -((a + 1.0) * 2.0 + 1.0 * b - c / (d * 3.0)) "
	};
	
	DoubleFunction functions[] = { (a, b, c, d) -> a + ((b + 1.0) * (c + 2.0)) / (d + 3.0),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - c / d),
			(a, b, c, d) -> -(((a + 1.0) * (2.0 + 1.0)) * b - (c + 1.0) / (d - 100.1)),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - (c / d) * 3.0),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - c / (d * 3.0)) };
	
	@Test
	void testVisit() {
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			FunctionNodeVisitorImpl visitor = new FunctionNodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			ExpressionNode node = parse(arithmeticExpression, visitor);
			String expression = node.toExpression();
			arithmeticExpression = arithmeticExpression.replaceAll("\\s", "");
			assertEquals(arithmeticExpression, expression, "expression: " + arithmeticExpressions[i]);
			Set<String> names = visitor.getVariableNames().stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
		}
	}
	
	@Test
	void testEval() {
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			FunctionNodeVisitorImpl visitor = new FunctionNodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			ExpressionNode node = parse(arithmeticExpression, visitor);
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			double d = 0.0;
			double r1 = functions[i].apply(a, b, c, d);
			double result = node.eval();
			assertEquals(r1, result, "expression: " + arithmeticExpressions[i]);
			
			a = 1.0;
			b = 2.0;
			c = 3.0;
			d = 4.0;
			r1 = functions[i].apply(a, b, c, d);
			
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", a);
			variableStack.setVariable("b", b);
			variableStack.setVariable("c", c);
			variableStack.setVariable("d", d);
			result = node.eval(variableStack);
			assertEquals(r1, result, "expression: " + arithmeticExpressions[i]);
		}
		
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
