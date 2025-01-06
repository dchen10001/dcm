package com.nice.antlr.ifstatement.parser.visit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import com.nice.antlr.ifstatement.node.action.DoAction;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.variable.VariableStack;
import com.nice.antlr.ifstatement.node.variable.VariableStackImpl;
import com.nice.antlr.ifstatement.parser.IfStatementLexer;
import com.nice.antlr.ifstatement.parser.IfStatementParser;
import com.nice.antlr.ifstatement.parser.IfStatementParser.IfstmtContext;
import com.nice.antlr.ifstatement.parser.listener.ThrowingErrorListener;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;

class IfStatementNodeVisitImplTest {
	@Test
	void testIfStatementVisit() {
		ExecutionNodeVisitorImpl visitor = new ExecutionNodeVisitorImpl();

		{
			String expr = """
					if (a < b)
                        print 2.0
                    else
					    print 3.0
                    endif
                    """;
			IfStatement ifStatement = parse(expr, visitor);
			String expression = ifStatement.toExpression();
			String exp = 
"""
if a<b {
    PRINT 2.0
}
else {
    PRINT 3.0
}
""";
			assertEquals(exp, expression);

			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b"), names);
			
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());			
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", 1.0);
			variableStack.setVariable("b", 2.0);
			
			DoAction action = ifStatement.eval(variableStack);
			assertEquals("PRINT 2.0", action.toExpression());
			
			variableStack.setVariable("a", 2.0);
			variableStack.setVariable("b", 1.0);
			action = ifStatement.eval(variableStack);
			assertEquals("PRINT 3.0", action.toExpression());
		}

		{
			String expr = """
					if (a < b)
                        print 2.0
					elseif (a >= b && a < b + 2.0)
						print 3.0
					elseif (a >= b + 2.0 && a < b + 3.0)
						print 4.0
                    else
					    print 5.0
                    endif
                    """;
			IfStatement ifStatement = parse(expr, visitor);
			String expression = ifStatement.toExpression();
			String exp = 
"""
if a<b {
    PRINT 2.0
}
elseif a>=b&&a<(b+2.0) {
    PRINT 3.0
}
elseif a>=(b+2.0)&&a<(b+3.0) {
    PRINT 4.0
} 
else { 
    PRINT 5.0
}
""";
			assertEquals(exp, expression);
			
			Set<String> names = visitor.getVariableNames(Double.class).stream().collect(Collectors.toSet());
			assertEquals(Set.of("a", "b"), names);
			
			names = visitor.getAssignmentNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());			
			names = visitor.getAssignmentNames(Double.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			names = visitor.getVariableNames(Boolean.class).stream().collect(Collectors.toSet());
			assertTrue(names.isEmpty());
			
			VariableStack variableStack = new VariableStackImpl();
			variableStack.setVariable("a", 1.0);
			variableStack.setVariable("b", 2.0);
			
			DoAction action = ifStatement.eval(variableStack);
			assertEquals("PRINT 2.0", action.toExpression());
			
			variableStack.setVariable("a", 2.0);
			variableStack.setVariable("b", 1.0);
			action = ifStatement.eval(variableStack);
			assertEquals("PRINT 3.0", action.toExpression());
			
			variableStack.setVariable("a", 3.0);
			variableStack.setVariable("b", 1.0);
			action = ifStatement.eval(variableStack);
			assertEquals("PRINT 4.0", action.toExpression());

			variableStack.setVariable("a", 4.0);
			variableStack.setVariable("b", 1.0);
			action = ifStatement.eval(variableStack);
			assertEquals("PRINT 5.0", action.toExpression());
		}
	}
	
	public IfStatement parse(String arithmeticExpression, ExecutionNodeVisitorImpl visitor) {
		visitor.reset();
		CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
		IfStatementLexer lexer = new IfStatementLexer(input);
    	lexer.removeErrorListeners();
    	ThrowingErrorListener errorListener = new ThrowingErrorListener();
    	lexer.addErrorListener(errorListener);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IfStatementParser parser = new IfStatementParser(tokens);
		parser.addErrorListener(errorListener);
		
		IfstmtContext ifstmt = parser.ifstmt();
		
		IfStatementWrapperImpl node = (IfStatementWrapperImpl) ifstmt.accept(visitor);
		return node.getIfStatement();
	}
}
