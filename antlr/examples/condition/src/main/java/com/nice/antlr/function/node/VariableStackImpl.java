package com.nice.antlr.function.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariableStackImpl implements VariableStack {

	private final Map<String, Double> variables = new HashMap<>();
	
	@Override
	public void setVariable(String name, double value) {
		variables.put(name, value);
	}

	@Override
	public void initVariable(String name) {
		setVariable(name, 0);
	}

	@Override
	public double getVariable(String name) {
		return variables.getOrDefault(name, 0d);
	}

	@Override
	public boolean isVariableExist(String name) {
		return variables.containsKey(name);
	}
	
	@Override
	public void clear() {
		variables.clear();
	}

	@Override
	public List<String> getVariableNames() {
		return variables.keySet().stream().toList();
	}
}
