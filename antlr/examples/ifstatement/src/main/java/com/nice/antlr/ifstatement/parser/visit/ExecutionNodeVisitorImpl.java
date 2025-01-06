package com.nice.antlr.ifstatement.parser.visit;

import java.util.ArrayList;
import java.util.List;

import com.nice.antlr.ifstatement.node.Execution;
import com.nice.antlr.ifstatement.node.ExecutionImpl;
import com.nice.antlr.ifstatement.node.action.DoAction;
import com.nice.antlr.ifstatement.node.action.PrintDoActionImpl;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.parser.IfStatementParser.AssignmentContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.DOPRINTContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.EXECUTEIFContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.EXECUTERULEContext;
import com.nice.antlr.ifstatement.parser.IfStatementParser.StartContext;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ActionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.AssignmentWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.ExecutionWrapperImpl;
import com.nice.antlr.ifstatement.parser.visit.nodewrapper.IfStatementWrapperImpl;

public class ExecutionNodeVisitorImpl extends IfStatementNodeVisitImpl {

	@Override
	public ExecutionWrapperImpl visitStart(StartContext ctx) {
		logger.trace("Visiting Start: {}", ctx.getText());
		reset();
		return (ExecutionWrapperImpl)visit(ctx.execution());
	}

	@Override
	public ExecutionWrapperImpl visitEXECUTEIF(EXECUTEIFContext ctx) {
		logger.trace("Visiting EXECUTEIF: {}", ctx.getText());
		List<Assignment<?>> assignments = new ArrayList<>();
		for(AssignmentContext assignmentContext : ctx.assignment()) {
			AssignmentWrapperImpl node = (AssignmentWrapperImpl)visit(assignmentContext);
			assignments.add(node.getAssignment());
		}

		IfStatement ifStatement = ((IfStatementWrapperImpl)visit(ctx.ifstmt())).getIfStatement();
		
		Execution execution = new ExecutionImpl(assignments, ifStatement);
		return new ExecutionWrapperImpl(execution);
	}

	@Override
	public ExecutionWrapperImpl visitEXECUTERULE(EXECUTERULEContext ctx) {
		logger.trace("Visiting EXECUTERULE: {}", ctx.getText());
		DoAction action = ((ActionWrapperImpl)visit(ctx.doRule())).getAction();
		Execution execution = new ExecutionImpl(action);
		return new ExecutionWrapperImpl(execution);
	}
	
	//replace with distribution rule set
	@Override
	public ActionWrapperImpl visitDOPRINT(DOPRINTContext ctx) {
		logger.trace("Visiting DOPRINT: {}", ctx.getText());
		double d = Double.parseDouble(ctx.DOUBLE().getText());
		return new ActionWrapperImpl(new PrintDoActionImpl(d));
	}
}
