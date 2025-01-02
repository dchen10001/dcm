package com.nice.antlr.ifstatement.node;

import java.util.List;

import com.nice.antlr.ifstatement.node.action.Action;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatementImpl;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class ExecutionImpl implements Execution {
	private final List<Assignment<?>> assignments;
	private final IfStatement ifStatement;
	
	public ExecutionImpl(@NonNull List<Assignment<?>> assignments, @NonNull  IfStatement ifStatement) {
		this.assignments = assignments;
		this.ifStatement = ifStatement;
	}
	
	@Override
	public Action eval(VariableStack variableStack) {
		for (Assignment<?> assignment : assignments) {
			assignment.eval(variableStack);
		}
		return ifStatement.eval(variableStack);
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		for (Assignment<?> assignment : assignments) {
			sb.append(assignment.toExpression()).append("\n");
		}
		sb.append(ifStatement.toExpression());
		return sb.toString();
	}
}
