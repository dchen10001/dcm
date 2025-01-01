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
import com.nice.antlr.function.node.Execution;
import com.nice.antlr.function.node.condition.Condition;
import com.nice.antlr.function.node.variable.VariableStack;
import com.nice.antlr.function.node.variable.VariableStackImpl;
import com.nice.antlr.function.parser.visit.ScriptNodeVisitorImpl;
import com.nice.antlr.function.parser.visit.nodewrapper.ExecutionWrapperImpl;

class ExecutionVisitorImplTest {
	String arithmeticExpressions[] = { 			
			"""
				set a0 = 13
				set a1 = a + ((b + 1.0) * (c + 2.0))
				set b1 = (d + 3.0)
				set c1 = a1 / b1 
				c1 > 1.0
			"""
	};
	
	String expectExpressions[] = { 			
"""
set a0 = 13.0
set a1 = a+(b+1.0)*(c+2.0)
set b1 = d+3.0
set c1 = a1/b1
c1>1.0			
"""
	};
	
	@Test
	void testVisit() {
		VariableStack variableStack = new VariableStackImpl();
		ScriptNodeVisitorImpl visitor = new ScriptNodeVisitorImpl();
		for (int i = 0; i < arithmeticExpressions.length; i++) {
			String expression = arithmeticExpressions[i];
			
			Execution execution = parse(expression, visitor);
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b", "c", "d"), names);
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a0", "a1", "b1", "c1"), names);

			assertEquals(expectExpressions[i].substring(0, expectExpressions[i].length() - 1), 
					execution.toExpression(), "expression: " + expression);
			variableStack.clear();
			assertEquals(false, execution.eval(variableStack));
		}
	}
	
	@Test
	void testBasicVisit() {
		VariableStack variableStack = new VariableStackImpl();
		ScriptNodeVisitorImpl visitor = new ScriptNodeVisitorImpl();
		String expression = "2.0 < 3.0 ";
		Execution execution = parse(expression, visitor);
		assertEquals("2.0<3.0", execution.toExpression(), "expression: " + expression);
		variableStack.clear();
		assertEquals(true, execution.eval(variableStack));
	}
	
	public Execution parse(String arithmeticExpression, ScriptNodeVisitorImpl visitor) {
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		ConditionLexer lexer = new ConditionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ConditionParser parser = new ConditionParser(tokens);
		ParseTree tree = parser.start();
		ExecutionWrapperImpl node = (ExecutionWrapperImpl)visitor.visit(tree);
		return node.getExecution();
	}
}
