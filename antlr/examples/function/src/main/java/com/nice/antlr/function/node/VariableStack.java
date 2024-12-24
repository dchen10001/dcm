package com.nice.antlr.function.node;

import java.util.List;

public interface VariableStack {
	void setVariable(String name, double value);

	void initVariable(String name);
	
	double getVariable(String name);

	boolean isVariableExist(String name);
	
	List<String> getVariableNames();
	
	void clear();
}
