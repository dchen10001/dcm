package com.nice.antlr.ifstatement.node.variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariableMap<T> {
	private final Map<String, T> variables = new HashMap<>();
	
	public void setVariable(String name, T value) {
		variables.put(name, value);
	}
	
	public T getVariableValue(String name) {
		return variables.get(name);
	}

	public boolean containsVariable(String name) {
		return variables.containsKey(name);
	}
	
	public List<String> getVariableNames() {
		return variables.keySet().stream().toList();
	}

	public void clear() {
		variables.clear();
	}
}
