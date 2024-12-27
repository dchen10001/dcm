package com.nice.antlr.condition.parser.node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import com.nice.antlr.condition.parser.ConditionLexer;
import com.nice.antlr.condition.parser.ConditionParser;
import com.nice.antlr.function.node.Condition;
import com.nice.antlr.function.node.VariableStack;
import com.nice.antlr.function.node.VariableStackImpl;
import com.nice.antlr.function.parser.node.ConditionNodeImpl;
import com.nice.antlr.function.parser.node.ExpressionNodeImpl;
import com.nice.antlr.function.parser.node.NodeVisitorImpl;

class ConditionVisitorImplTest {
	String arithmeticExpressions[] = { 			
			" a  + b < c + d ",
			" a != b || c < d ",
			" a > 0 && b != 0 && c < d ",
			"""
				a + ((b + 1.0) * (c + 2.0)) / (d + 3.0) > 1.0
			""", 
			"""
				-((a + 1.0) * 2.0 + 1.0 * b - c / d) > 1.0 && a > 0.0
			""",
			" a <= c && d >= 0.0 && !(b == 0.0)",
			" a  >= c && d != 0.0 && !(b == 0.0)",
			" a == c || d >= 0.0 || !(b == 0.0)",
			" (a <= b && d >= 0.0) || (a >= c && d != 0.0) || !(a  == c || d >= 0.0)"
	};
	
	String expressions[] = {
			" (a+b) < (c+d) ",
			" a != b || c < d ",
			" (a > 0.0 && b != 0.0) && c < d ",
			"""
				(a + ((b + 1.0) * (c + 2.0)) / (d + 3.0)) > 1.0
			""", 
			"""
				(-((a + 1.0) * 2.0 + 1.0 * b - c / d)) > 1.0 && a > 0.0
			""",
			" (a <= c && d >= 0.0) && !(b == 0.0)",
			" (a>= c && d != 0.0) && !(b == 0.0)",
			" (a == c || d >= 0.0) || !(b == 0.0)",
			" ((a <= b && d >= 0.0) || (a >= c && d != 0.0)) || !(a  == c || d >= 0.0)"
	};
	
	BooleanFunction functions[] = { 
			(a, b, c, d) -> a + b < c + d,
			(a, b, c, d) -> a != b || c < d,
			(a, b, c, d) -> a > 0 && b != 0 && c < d,
			(a, b, c, d) -> a + ((b + 1.0) * (c + 2.0)) / (d + 3.0) > 1.0,
			(a, b, c, d) -> -((a + 1.0) * 2.0 + 1.0 * b - c / d) > 1.0 && a > 0.0,
			(a, b, c, d) -> a <= c && d >= 0.0 && !(b == 0.0),
			(a, b, c, d) -> a  >= c && d != 0.0 && !(b == 0.0) ,
			(a, b, c, d) -> a == c || d >= 0.0 || !(b == 0.0),
			(a, b, c, d) -> (a <= b && d >= 0.0) || (a  >= c && d != 0.0) || !(a  == c || d >= 0.0)
			};
	
	@Test
	void testBasicVisit() {
		VariableStack variableStack = new VariableStackImpl();
		NodeVisitorImpl visitor = new NodeVisitorImpl();
		String expression = "2.0 < 3.0 ";
		Condition condition = parse(expression, visitor);
		assertEquals("2.0<3.0", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		assertEquals(true, condition.eval(variableStack));
		
		//case 1: less than
		expression = "a < b ";
		condition = parse(expression, visitor);
		assertEquals("a<b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(false, condition.eval(variableStack));
		
		//case 2: less than and equal
		expression = "a <= b ";
		condition = parse(expression, visitor);
		assertEquals("a<=b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(true, condition.eval(variableStack));
		
		//case 3: equal
		expression = "a == b ";
		condition = parse(expression, visitor);
		assertEquals("a==b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 2.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		//case 4: not equal
		expression = "a != b ";
		condition = parse(expression, visitor);
		assertEquals("a!=b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 2.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		//case 5: greater than
		expression = "a > b ";
		condition = parse(expression, visitor);
		assertEquals("a>b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		//case 5: greater than and equal
		expression = "a >= b ";
		condition = parse(expression, visitor);
		assertEquals("a>=b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));

		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 3.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		expression = "(a >= b)";
		condition = parse(expression, visitor);
		assertEquals("a>=b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 3.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		//case 6: sign
		expression = "!(a > b)";
		condition = parse(expression, visitor);
		assertEquals("!(a>b)", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		expression = "!(!(a > b))";
		condition = parse(expression, visitor);
		assertEquals("!(!(a>b))", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(false, condition.eval(variableStack));
	}
	
	@Test
	void testBasicGroupVisit() {
		VariableStack variableStack = new VariableStackImpl();
		NodeVisitorImpl visitor = new NodeVisitorImpl();
		String expression = "2.0 < 3.0 && 2.0 != 3.0 ";
		Condition condition = parse(expression, visitor);
		assertEquals("2.0<3.0&&2.0!=3.0", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		assertEquals(true, condition.eval(variableStack));
		
		//case 1: and
		expression = "b > 3.0 && a < 3.0";
		condition = parse(expression, visitor);
		assertEquals("b>3.0&&a<3.0", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(false, condition.eval(variableStack));
		
		//case 2: and
		expression = "b > 3.0 && a < 3.0 && c > 0.0";
		condition = parse(expression, visitor);
		assertEquals("(b>3.0&&a<3.0)&&c>0.0", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", -4.0);
		assertEquals(false, condition.eval(variableStack));
		

		//case 3: or
		expression = "b > 3.0 || a < 3.0";
		condition = parse(expression, visitor);
		assertEquals("b>3.0||a<3.0", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(true, condition.eval(variableStack));

		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(false, condition.eval(variableStack));


		//case 4: and
		expression = "b > 3.0 || a < 3.0 || c > 0.0";
		condition = parse(expression, visitor);
		assertEquals("(b>3.0||a<3.0)||c>0.0", condition.toExpression(), "expression: " + expression);
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 2.0);
		variableStack.setVariable("c", -4.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 1.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		variableStack.setVariable("c", -4.0);
		assertEquals(true, condition.eval(variableStack));
		
		//case 5: sign
		expression = "!(b > 3.0 && a < 3.0)";
		condition = parse(expression, visitor);
		assertEquals("!(b>3.0&&a<3.0)", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(false, condition.eval(variableStack));

		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(true, condition.eval(variableStack));

		expression = "!(!(b > 3.0 && a < 3.0))";
		condition = parse(expression, visitor);
		assertEquals("!(!(b>3.0&&a<3.0))", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(true, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(false, condition.eval(variableStack));
		
		expression = "!(!(!(b > 3.0 && a < 3.0)))";
		condition = parse(expression, visitor);
		assertEquals("!(!(!(b>3.0&&a<3.0)))", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 4.0);
		assertEquals(false, condition.eval(variableStack));
		
		variableStack.clear();
		variableStack.setVariable("a", 4.0);
		variableStack.setVariable("b", 1.0);
		assertEquals(true, condition.eval(variableStack));
	}
	
	@Test
	void testVisit() {
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			System.out.println("i: " + i);
			NodeVisitorImpl visitor = new NodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			Condition condition = parse(arithmeticExpression, visitor);
			String expression = condition.toExpression();
			System.out.println("expression: " + expression);
			
			arithmeticExpression = expressions[i].replaceAll("\\s", "");
			assertEquals(arithmeticExpression, expression, "expression[" + i + "]: " + arithmeticExpressions[i]);
			Set<String> names = visitor.getVariableNames().stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
		}
	}
	
	@Test
	void testEval() {
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			NodeVisitorImpl visitor = new NodeVisitorImpl();
			String arithmeticExpression = arithmeticExpressions[i];
			Condition condition = parse(arithmeticExpression, visitor);
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			double d = 0.0;
			boolean r1 = functions[i].apply(a, b, c, d);
			VariableStack variableStack = new VariableStackImpl();
			boolean result = condition.eval(variableStack);
			assertEquals(r1, result, "expression: " + arithmeticExpressions[i]);
			
			a = 1.0;
			b = 2.0;
			c = 3.0;
			d = 4.0;
			r1 = functions[i].apply(a, b, c, d);
			variableStack.clear();
			variableStack.setVariable("a", a);
			variableStack.setVariable("b", b);
			variableStack.setVariable("c", c);
			variableStack.setVariable("d", d);
			result = condition.eval(variableStack);
			assertEquals(r1, result, "expression: " + arithmeticExpressions[i]);
		}
		
	}

	public Condition parse(String arithmeticExpression, NodeVisitorImpl visitor) {
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		ConditionLexer lexer = new ConditionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ConditionParser parser = new ConditionParser(tokens);
		//ParseTree tree = parser.start();
		ConditionNodeImpl node = (ConditionNodeImpl)parser.conditiongroup().accept(visitor);
		//ConditionNodeImpl node = (ConditionNodeImpl)visitor.visit(tree);
		return node.getCondition();
	}
}
