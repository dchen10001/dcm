package com.nice.antlr.function.node;

import java.util.List;

import lombok.NonNull;

public class ExecutionImpl implements Execution {
	private final List<Assignment> assignments;
	private final Condition condition;
	
	public ExecutionImpl(@NonNull List<Assignment> assignments, @NonNull Condition condition) {
		this.assignments = assignments;
		this.condition = condition;
	}
	
	@Override
	public boolean eval(VariableStack variableStack) {
		for (Assignment assignment : assignments) {
			assignment.eval(variableStack);
		}
		return condition.eval(variableStack);
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		for (Assignment assignment : assignments) {
			sb.append(assignment.toExpression()).append("\n");
		}
		sb.append(condition.toExpression());
		return sb.toString();
	}
}
