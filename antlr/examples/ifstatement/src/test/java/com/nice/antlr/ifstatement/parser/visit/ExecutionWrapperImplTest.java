package com.nice.antlr.ifstatement.parser.visit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import com.nice.antlr.ifstatement.node.Execution;
import com.nice.antlr.ifstatement.node.action.Action;
import com.nice.antlr.ifstatement.node.variable.VariableStack;
import com.nice.antlr.ifstatement.node.variable.VariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementLexer;
import com.nice.antlr.ifstatement.parser.IfStatementParser;
import com.nice.antlr.ifstatement.parser.listener.ThrowingErrorListener;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExecutionWrapperImpl;

class ExecutionWrapperImplTest {
	
	@Test
	void testIFStatementVisit() {
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
		String expr = """
				set a1 = a + ((b + 1.0) * (c + 2.0))
				set b1 = (d + 3.0)
				set c1 = a1 < b1 && e
				if (c1)
                    print 2.0
                else
				    print 3.0
                endif
                """;
		Execution execution = parse(expr, visitor);
		
		String expression = execution.toExpression();
		String exp = 
"""
set a1 = a+(b+1.0)*(c+2.0)
set b1 = d+3.0
set c1 = a1<b1&&e
if c1 {
    PRINT 2.0
}
else {
    PRINT 3.0
}
""";
		assertEquals(exp, expression);
		
		Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("a", "b", "c", "d"), names);
		
		names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("e"), names);
		
		names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("a1", "b1"), names);

		names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("c1"), names);
		
		VariableStack variableStack = new VariableStackImpl();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		variableStack.setVariable("c", 3.0);
		variableStack.setVariable("d", 4.0);
		variableStack.setVariable("e", true);
		
		Action action = execution.eval(variableStack);
		
		assertEquals("PRINT 3.0", action.toExpression());
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 2.0);
		variableStack.setVariable("c", -3.0);
		variableStack.setVariable("d", 4.0);
		action = execution.eval(variableStack);
		assertEquals("PRINT 2.0", action.toExpression());
	}
	
	
	@Test
	void testIfElseIfVisit() {
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();
		String expr = """
				set a1 = a + ((b + 1.0) * (c + 2.0))
				set b1 = (d + 3.0)
				if a1 < 2.0
                    print 2.0
                elseif a1 < 3.0 && a1 >= 2.0
				    print 3.0
                elseif a1 < 4.0 && a1 >= 3.0
				    print 4.0                 
                else
				    print 5.0
                endif
                """;
		Execution execution = parse(expr, visitor);
		
		String expression = execution.toExpression();
		String exp = 
"""
set a1 = a+(b+1.0)*(c+2.0)
set b1 = d+3.0
if a1<2.0 {
    PRINT 2.0
}
elseif a1<3.0&&a1>=2.0 {
    PRINT 3.0
}
elseif a1<4.0&&a1>=3.0 {
    PRINT 4.0
}
else {
    PRINT 5.0
}
""";
		assertEquals(exp, expression);
		
		Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("a", "b", "c", "d"), names);
		
		names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of(), names);
		
		names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of("a1", "b1"), names);
		
		names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
		assertEquals(Set.of(), names);
		
		VariableStack variableStack = new VariableStackImpl();
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", -1.0);
		variableStack.setVariable("c", 3.0);
		variableStack.setVariable("d", 4.0);
		variableStack.setVariable("e", true);
		
		Action action = execution.eval(variableStack);
		
		assertEquals("PRINT 2.0", action.toExpression());
		
		variableStack.setVariable("a", 1.0);
		variableStack.setVariable("b", 0.0);
		variableStack.setVariable("c", -1.0);
		variableStack.setVariable("d", 4.0);
		
		action = execution.eval(variableStack);
		assertEquals("PRINT 3.0", action.toExpression());
		
		variableStack.setVariable("a", 2.5);
		variableStack.setVariable("b", 0.0);
		variableStack.setVariable("c", -1.0);
		variableStack.setVariable("d", 4.0);
		
		action = execution.eval(variableStack);
		assertEquals("PRINT 4.0", action.toExpression());
		
		variableStack.setVariable("a", 3.5);
		variableStack.setVariable("b", 0.0);
		variableStack.setVariable("c", -1.0);
		variableStack.setVariable("d", 4.0);
		
		action = execution.eval(variableStack);
		assertEquals("PRINT 5.0", action.toExpression());
		
		variableStack.setVariable("a", 4.5);
		variableStack.setVariable("b", 0.0);
		variableStack.setVariable("c", -1.0);
		variableStack.setVariable("d", 4.0);
		
		action = execution.eval(variableStack);
		assertEquals("PRINT 5.0", action.toExpression());
	}
	
	public Execution parse(String arithmeticExpression, ExecutionNodeVisitorImpl visitor) {
		visitor.reset();
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		IfStatementLexer lexer = new IfStatementLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IfStatementParser parser = new IfStatementParser(tokens);
		parser.addErrorListener(errorListener);
		
		ParseTree tree = parser.start();
		ExecutionWrapperImpl node = (ExecutionWrapperImpl)visitor.visit(tree);
		return node.getExecution();
	}
}
