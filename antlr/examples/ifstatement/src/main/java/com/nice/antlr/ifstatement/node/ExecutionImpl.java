package com.nice.antlr.ifstatement.node;

import java.util.List;

import com.nice.antlr.ifstatement.node.action.DoAction;
import com.nice.antlr.ifstatement.node.assignment.Assignment;
import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class ExecutionImpl implements Execution {
	private final List<Assignment<?>> assignments;
	private final IfStatement ifStatement;

	private final DoAction action;
	
	public ExecutionImpl(@NonNull List<Assignment<?>> assignments, @NonNull IfStatement ifStatement) {
		this.assignments = assignments;
		this.ifStatement = ifStatement;
		this.action = null;
	}
	
	public ExecutionImpl(@NonNull DoAction action) {
		this.assignments = null;
		this.ifStatement = null;
		this.action = action;
	}

	@Override
	public DoAction eval(VariableStack variableStack) {
		if (isDebugEnable()) {
			debug("<------------------ Start Execution Debug Info-------------------");
		}
		
		try {
			if (action != null) {
				if (isDebugEnable()) {
					debug("DO " + this.action.toExpression());
				}
				return action;
			}
			
			for (Assignment<?> assignment : assignments) {
				assignment.eval(variableStack);
			}
			return ifStatement.eval(variableStack);
		} finally {
			if (isDebugEnable()) {
				debug("<------------------ End Execution Debug Info-------------------");
			}
		}
	}

	@Override
	public String toExpression() {
		if (action != null) {
			return action.toExpression();
		}
		
		StringBuilder sb = new StringBuilder();
		for (Assignment<?> assignment : assignments) {
			sb.append(assignment.toExpression()).append("\n");
		}
		sb.append(ifStatement.toExpression());
		return sb.toString();
	}
}
