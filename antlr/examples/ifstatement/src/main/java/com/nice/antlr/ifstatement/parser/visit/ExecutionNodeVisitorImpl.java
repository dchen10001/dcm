package com.nice.antlr.ifstatement.parser.visit;

import java.util.ArrayList;
import java.util.List;

import com.nice.antlr.ifstatement.node.Execution;
import com.nice.antlr.ifstatement.node.ExecutionImpl;
import com.nice.antlr.ifstatement.node.action.PrintActionImpl;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.parser.IfStatementParser.AssignmentContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.BOOLEANContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.CNDASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.EXPRASSSIGNMENTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.PRINTDOUBLEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.StartContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ActionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExecutionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.NodeWrapper;

public class ExecutionNodeVisitorImpl extends IfStatementNodeVisitImpl {

	@Override
	public ExecutionWrapperImpl visitStart(StartContext ctx) {
		logger.trace("Visiting Start: {}", ctx.getText());
		reset();
		List<Assignment<?>> assignments = new ArrayList<>();
		for(AssignmentContext assignmentContext : ctx.assignment()) {
			AssignmentWrapperImpl node = (AssignmentWrapperImpl)visit(assignmentContext);
			assignments.add(node.getAssignment());
		}

		IfStatement ifStatement = ((IfStatementWrapperImpl)visit(ctx.ifstmt())).getIfStatement();
		
		Execution execution = new ExecutionImpl(assignments, ifStatement);
		return new ExecutionWrapperImpl(execution);
	}

	//replace with distribution rule set
	@Override
	public ActionWrapperImpl visitPRINTDOUBLE(PRINTDOUBLEContext ctx) {
		logger.trace("Visiting PRINTSTMT: {}", ctx.getText());
		double d = Double.parseDouble(ctx.DOUBLE().getText());
		return new ActionWrapperImpl(new PrintActionImpl(d));
	}
}
