package com.nice.antlr.function.node;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodeVariableStackImpl implements NodeVariableStack {

	private final Set<String> variables = new HashSet<>();

	private final Set<String> assignments = new HashSet<>();

	@Override
	public void addAssignmentVariable(String name) {
		if(!this.variables.contains(name)) {
			this.assignments.add(name);
		}
	}

	@Override
	public void addExpressionVariable(String name) {
		if(!this.assignments.contains(name)) {
			this.variables.add(name);
		}
	}

	@Override
	public List<String> getVariableNames() {
		return this.variables.stream().toList();
	}

	@Override
	public List<String> getAssignmentVariable() {
		return this.assignments.stream().toList();
	}

	@Override
	public void clear() {
		this.assignments.clear();
		this.variables.clear();
	}
}
