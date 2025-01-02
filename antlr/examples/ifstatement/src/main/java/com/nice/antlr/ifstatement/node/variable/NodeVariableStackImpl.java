package com.nice.antlr.ifstatement.node.variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NodeVariableStackImpl implements NodeVariableStack {
	
	private final Set<String> assignments = new HashSet<>();

	private final Map<String, Class<?>> variableType = new HashMap<>();
	
	@Override
	public void addAssignmentVariable(String name, Class<?> type) {
		checkVariable(name, type);
		this.variableType.put(name, type);
		this.assignments.add(name);
	}

	@Override
	public void addParameterVariable(String name, Class<?> type) {
		checkVariable(name, type);
		this.variableType.put(name, type);
	}

	private void checkVariable(String name, Class<?> type) {
		if (this.variableType.containsKey(name) && !this.variableType.get(name).equals(type)) {
			throw new IllegalArgumentException("Variable " + name + " is already defined as another type");
		}
	}
	
	@Override
	public Map<String, Class<?>> getVariables() {
		 return variableType.entrySet().stream()
				.filter(e -> !this.assignments.contains(e.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
	
	@Override
	public Map<String, Class<?>> getAssignments() {
		return variableType.entrySet().stream()
				.filter(e -> this.assignments.contains(e.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Override
	public void clear() {
		this.assignments.clear();
		this.variableType.clear();
	}
}
