package com.nice.antlr.function.node;

import java.util.List;

public interface NodeVariableStack {
	void addAssignmentVariable(String name);
	void addExpressionVariable(String name);
	List<String> getVariableNames();
	List<String> getAssignmentVariable();
	void clear();
}
