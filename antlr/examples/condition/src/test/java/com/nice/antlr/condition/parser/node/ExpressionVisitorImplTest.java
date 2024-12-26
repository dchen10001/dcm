package com.nice.antlr.condition.parser.node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import com.nice.antlr.condition.parser.ConditionLexer;
import com.nice.antlr.condition.parser.ConditionParser;
import com.nice.antlr.function.node.Expression;
import com.nice.antlr.function.node.VariableStack;
import com.nice.antlr.function.node.VariableStackImpl;
import com.nice.antlr.function.parser.node.ExpressionNodeImpl;
import com.nice.antlr.function.parser.node.NodeVisitorImpl;

class ExpressionVisitorImplTest {
	String arithmeticExpressions[] = {
			"a + b * c - d",
			"a * b + c/d",
			" a + ((b + 1.0) * (c + 2.0)) / (d + 3.0)"
			, " -((a + 1.0) * 2.0 + 1.0 * b - c / d) "
			, " -(((a + 1.0) * (2.0 + 1.0)) * b - (c + 1.0) / (d - 100.1)) "
			, " -((a + 1.0) * 2.0 + 1.0 * b - (c / d) * 3.0) "
			, " -((a + 1.0) * 2.0 + 1.0 * b - c / (d * 3.0)) "
	};
	
	DoubleFunction functions[] = { 
			(a, b, c, d) -> a + b * c - d,
			(a, b, c, d) -> a * b + c/d,
			(a, b, c, d) -> a + ((b + 1.0) * (c + 2.0)) / (d + 3.0),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - c / d),
			(a, b, c, d) -> -(((a + 1.0) * (2.0 + 1.0)) * b - (c + 1.0) / (d - 100.1)),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - (c / d) * 3.0),
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - c / (d * 3.0)) };
	
	@Test
	void testBasicVisit() {
		VariableStack variableStack = new VariableStackImpl();
		NodeVisitorImpl visitor = new NodeVisitorImpl();

		String expression = "2 + 4";
		Expression node = parse(expression, visitor);
		assertEquals("2.0+4.0", node.toExpression());
		variableStack.clear();
		assertEquals(6, node.eval(variableStack));
		
		expression = "a + b";
		node = parse(expression, visitor);
		assertEquals("a+b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 2);
		variableStack.setVariable("b", 4);
		assertEquals(6, node.eval(variableStack));
		
		expression = "(a + b)";
		node = parse(expression, visitor);
		assertEquals("a+b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 2);
		variableStack.setVariable("b", 4);
		assertEquals(6, node.eval(variableStack));
		
		expression = "a - b";
		node = parse(expression, visitor);
		assertEquals("a-b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 2);
		variableStack.setVariable("b", 4);
		assertEquals(-2, node.eval(variableStack));
		
		expression = "a * b";
		node = parse(expression, visitor);
		assertEquals("a*b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 2);
		variableStack.setVariable("b", 4);
		assertEquals(8, node.eval(variableStack));
		
		expression = "a / b";
		node = parse(expression, visitor);
		assertEquals("a/b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 2);
		variableStack.setVariable("b", 4);
		assertEquals(0.5, node.eval(variableStack));
		
		expression = "a % b";
		node = parse(expression, visitor);
		assertEquals("a%b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 3);
		variableStack.setVariable("b", 4);
		assertEquals(3, node.eval(variableStack));
		
		expression = "-a * b";
		node = parse(expression, visitor);
		assertEquals("(-(a))*b", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 3);
		variableStack.setVariable("b", 4);
		assertEquals(-12, node.eval(variableStack));
		
		expression = "-(a * b)";
		node = parse(expression, visitor);
		assertEquals("-(a*b)", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 3);
		variableStack.setVariable("b", 4);
		assertEquals(-12, node.eval(variableStack));
		
		expression = "-(-(a * b))";
		node = parse(expression, visitor);
		assertEquals("-(-(a*b))", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 3);
		variableStack.setVariable("b", 4);
		assertEquals(12, node.eval(variableStack));
		
		expression = "(-(-(a * b)))";
		node = parse(expression, visitor);
		assertEquals("-(-(a*b))", node.toExpression());
		variableStack.clear();
		variableStack.setVariable("a", 3);
		variableStack.setVariable("b", 4);
		assertEquals(12, node.eval(variableStack));
	}
	
	@Test
	void testVisit() {
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			NodeVisitorImpl visitor = new NodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			Expression node = parse(arithmeticExpression, visitor);
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
			NodeVisitorImpl visitor = new NodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			Expression node = parse(arithmeticExpression, visitor);
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

	public Expression parse(String arithmeticExpression, NodeVisitorImpl visitor) {
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		ConditionLexer lexer = new ConditionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ConditionParser parser = new ConditionParser(tokens);
		ExpressionNodeImpl node = (ExpressionNodeImpl)parser.expr().accept(visitor);
		return node.getExpression();
	}
}
