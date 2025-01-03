package com.nice.antlr.ifstatement.parser.visit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;
import com.nice.antlr.ifstatement.node.variable.VariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementLexer;
import com.nice.antlr.ifstatement.parser.IfStatementParser;
import com.nice.antlr.ifstatement.parser.IfStatementParser.ConditiongroupContext;
import com.nice.antlr.ifstatement.parser.listener.ThrowingErrorListener;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ConditionWrapperImpl;

class ConditionNodeVisitImplTest {
	
	String conditionExpressions[] = { 	
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
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
		String expression = "a && 2.0 < 3.0 ";
		visitor.reset();
		Condition condition = parse(expression, visitor);
		assertEquals("a&&2.0<3.0", condition.toExpression(), "expression: " + expression);
		assertTrue(visitor.getAssignmentNames(Double.class).isEmpty());
		assertTrue(visitor.getAssignmentNames(Boolean.class).isEmpty());
		assertTrue(visitor.getVariableNames(Double.class).isEmpty());
		
		assertEquals(List.of("a"), visitor.getVariableNames(Boolean.class));
		
		variableStack.clear();
		variableStack.setVariable("a", Boolean.TRUE);
		
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
		
		expression = "true";
		condition = parse(expression, visitor);
		assertEquals("true", condition.toExpression(), "expression: " + expression);
		assertEquals(true, condition.eval(variableStack));

		expression = "false";
		condition = parse(expression, visitor);
		assertEquals("false", condition.toExpression(), "expression: " + expression);
		assertEquals(false, condition.eval(variableStack));
		
		
		expression = "true && (a >= b)";
		condition = parse(expression, visitor);
		assertEquals("true&&a>=b", condition.toExpression(), "expression: " + expression);
		variableStack.clear();
		variableStack.setVariable("a", 3.0);
		variableStack.setVariable("b", 2.0);
		assertEquals(true, condition.eval(variableStack));
	}
	
	@Test
	void testBasicGroupVisit() {
		VariableStack variableStack = new VariableStackImpl();
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
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
		for (int i = 0; i < conditionExpressions.length; i++) {
			System.out.println("i: " + i);
			ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
			String arithmeticExpression = conditionExpressions[i];
			Condition condition = parse(arithmeticExpression, visitor);
			String expression = condition.toExpression();
			System.out.println("expression: " + expression);
			
			arithmeticExpression = expressions[i].replaceAll("\\s", "");
			assertEquals(arithmeticExpression, expression, "expression[" + i + "]: " + conditionExpressions[i]);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
		}
	}
	
	@Test
	void testEval() {
		for (int i = 0; i < conditionExpressions.length; i++) {
			ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
			String arithmeticExpression = conditionExpressions[i];
			Condition condition = parse(arithmeticExpression, visitor);
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			double d = 0.0;
			boolean r1 = functions[i].apply(a, b, c, d);
			VariableStack variableStack = new VariableStackImpl();
			boolean result = condition.eval(variableStack);
			assertEquals(r1, result, "expression: " + conditionExpressions[i]);
			
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
			assertEquals(r1, result, "expression: " + conditionExpressions[i]);
		}		
	}

	public Condition parse(String arithmeticExpression, ExecutionNodeVisitorImpl visitor) {
		visitor.reset();
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		IfStatementLexer lexer = new IfStatementLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IfStatementParser parser = new IfStatementParser(tokens);
		parser.addErrorListener(errorListener);
		
		ConditiongroupContext conditiongroup = parser.conditiongroup();
		
		ConditionWrapperImpl node = (ConditionWrapperImpl)conditiongroup.accept(visitor);
		return node.getCondition();
	}
}
