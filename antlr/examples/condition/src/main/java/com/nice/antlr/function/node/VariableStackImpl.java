package com.nice.antlr.function.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		double value = variables.getOrDefault(name, 0d);
		if(Execution.isDebugEnable()) {
			String script = "variable " + name;
			String strValue = String.valueOf(value);			
			if(!this.isVariableExist(name)) {
				strValue = strValue + " by default";
			}
			Execution.debug(script, strValue);
		}
		return value;
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
