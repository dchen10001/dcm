package com.nice.antlr.function.node.variable;

import java.util.List;

import lombok.NonNull;

public interface VariableStack {
	void setVariable(String name, @NonNull Object value);
	
	<T> T getVariableValue(String name, Class<T> cls);
	
	List<String> getVariableNames(Class<?> cls);
	
	void clear();
}
