package com.nice.antlr.ifstatement.parser.visit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.variable.VariableStack;
import com.nice.antlr.ifstatement.node.variable.VariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementLexer;
import com.nice.antlr.ifstatement.parser.IfStatementParser;
import com.nice.antlr.ifstatement.parser.IfStatementParser.AssignmentContext;
import com.nice.antlr.ifstatement.parser.listener.ThrowingErrorListener;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;

class AssignmentNodeVisitImplTest {
	String exprAssignment[] = { 			
			"set e = 2 ",
			"set e = a  + b * c - d ",
			"set e = (a * b + c/d) ",
			"set e = a + ((b + 1.0) * (c + 2.0)) / (d + 3.0) "
	};

	String expectExpr[] = { 			
			"set e = 2.0",
			"set e = a+b*c-d",
			"set e = a*b+c/d",
			"set e = a+((b+1.0)*(c+2.0))/(d+3.0)"
	};

	DoubleFunction exprFunction[] = { 
			(a, b, c, d) -> 2.0 ,
			(a, b, c, d) -> a  + b * c - d ,
			(a, b, c, d) -> (a * b + c/d) ,
			(a, b, c, d) -> a + ((b + 1.0) * (c + 2.0)) / (d + 3.0) 
		};
	
	String cndAssignment[] = { 			
			"set e = a  + b < c + d ",
			"set e = a != b || c < d ",
			"set  e = (a <= b && d >= 0.0) || (a >= c && d != 0.0) || !(a  == c || d >= 0.0)"
	};
	
	String expectCnd[] = { 			
			"set e = a+b<c+d",
			"set e = a!=b||c<d",
			"set e = ((a<=b&&d>=0.0)||(a>=c&&d!=0.0))||!(a==c||d>=0.0)"
	};
	
	BooleanFunction cndFunctions[] = { 
			(a, b, c, d) -> a  + b < c + d,
			(a, b, c, d) -> a != b || c < d,
			(a, b, c, d) -> (a <= b && d >= 0.0) || (a >= c && d != 0.0) || !(a  == c || d >= 0.0)
			};
	
	@Test
	void testExpressionAssignmentVisit() {
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();

		{
			int i = 0;
			String expr = exprAssignment[i];
			Assignment<?> assignment = parse(expr, visitor);
			
			String expression = assignment.toExpression();
			
			assertEquals(expectExpr[i], expression, "expression[" + i + "]: " + exprAssignment[i]);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("e"), names);
			
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			assignment.eval(variableStack);
			Double value = variableStack.getVariableValue("e", Double.class);
			assertEquals(exprFunction[i].apply(1.0, 2.0, 3.0, 4.0), value);
		}
		
		for (int i = 1; i < exprAssignment.length; i++) {
			System.out.println("i: " + i);
			String expr = exprAssignment[i];
			Assignment<?> assignment = parse(expr, visitor);
			
			String expression = assignment.toExpression();
			
			assertEquals(expectExpr[i], expression, "expression[" + i + "]: " + exprAssignment[i]);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
			
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("e"), names);
			
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", 1.0);
			variableStack.setVariable("b", 2.0);
			variableStack.setVariable("c", 3.0);
			variableStack.setVariable("d", 4.0);
			assignment.eval(variableStack);
			Double value = variableStack.getVariableValue("e", Double.class);
			assertEquals(exprFunction[i].apply(1.0, 2.0, 3.0, 4.0), value);
		}
	}
	
	@Test
	void testCondtionAssignmentVisit() {
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();

		{
			String expr ="set e = true";
			Assignment<?> assignment = parse(expr, visitor);
			
			String expression = assignment.toExpression();
			assertEquals("set e = true", expression);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("e"), names);
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			assignment.eval(variableStack);
			Boolean value = variableStack.getVariableValue("e", Boolean.class);
			assertEquals(true, value);
		}
		
		{
			String expr ="set e = false";
			Assignment<?> assignment = parse(expr, visitor);
			
			String expression = assignment.toExpression();
			assertEquals("set e = false", expression);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("e"), names);
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			assignment.eval(variableStack);
			Boolean value = variableStack.getVariableValue("e", Boolean.class);
			assertEquals(false, value);
		}
		
		
		for (int i = 1; i < cndAssignment.length; i++) {
			System.out.println("i: " + i);
			String expr = cndAssignment[i];
			Assignment<?> assignment = parse(expr, visitor);
			
			String expression = assignment.toExpression();
			
			assertEquals(expectCnd[i], expression, "expression[" + i + "]: " + cndAssignment[i]);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
			
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("e"), names);
			
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", 1.0);
			variableStack.setVariable("b", 2.0);
			variableStack.setVariable("c", 3.0);
			variableStack.setVariable("d", 4.0);
			assignment.eval(variableStack);
			Boolean value = variableStack.getVariableValue("e", Boolean.class);
			assertEquals(cndFunctions[i].apply(1.0, 2.0, 3.0, 4.0), value);
		}
	}
	
	public Assignment<?> parse(String arithmeticExpression, ExecutionNodeVisitorImpl visitor) {
		visitor.reset();
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		IfStatementLexer lexer = new IfStatementLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IfStatementParser parser = new IfStatementParser(tokens);
		parser.addErrorListener(errorListener);
		
		 AssignmentContext assignment = parser.assignment();
		
		AssignmentWrapperImpl node = (AssignmentWrapperImpl) assignment.accept(visitor);
		return node.getAssignment();
	}
}
