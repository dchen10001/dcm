package com.nice.antlr.function.node.variable;

import java.util.Map;

public interface NodeVariableStack {
	void addAssignmentVariable(String name, Class<?> type);

	void addParameterVariable(String name, Class<?> type);

	public Map<String, Class<?>> getVariables();

	public Map<String, Class<?>> getAssignments();

	void clear();
}
