package com.nice.antlr.function.node.variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VariableStackImpl implements VariableStack {

	private final Map<String, Object> variableValue = new HashMap<>();
	private final Map<String, Class<?>> variableType = new HashMap<>();
	
	@Override
	public void setVariable(String name, Object value) {
		Object v = toDouble(value);
		checkVariable(name, v.getClass());
		this.variableValue.put(name, v);
		this.variableType.put(name, v.getClass());
	}

	private Object toDouble(Object value) {
		Class<? extends Object> type = value.getClass();
		if (type.equals(Double.class)) {
			return value;
		} else if (type.equals(Boolean.class)) {
			return value;
		} else if (type.equals(Integer.class) || type.equals(Long.class)) {
			return Double.valueOf(value.toString());
		}
		throw new IllegalArgumentException("Invalid data type: " + type.getSimpleName());
	}
	
	@Override
	public void clear() {
		this.variableType.clear();
		this.variableValue.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getVariableValue(String name, Class<T> type) {
		if (this.variableType.containsKey(name) && !this.variableType.get(name).equals(type)) {
			throw new IllegalArgumentException("Variable " + name + " is defined as another type");
		}

		if (!this.variableValue.containsKey(name)) {
			return getDefaultValue(type);
		}
		
		return (T) this.variableValue.get(name);
	}

	@SuppressWarnings("unchecked")
	private <T> T getDefaultValue(Class<T> cls) {
		if (cls.equals(Boolean.class)) {
			return (T) Boolean.FALSE;
		} else if (cls.equals(Double.class)) {
			return (T) Double.valueOf(0);
		}
		return null;
	}

	@Override
	public List<String> getVariableNames(Class<?> cls) {
		return this.variableType.entrySet().stream()
				.filter(e -> e.getValue().equals(cls))
				.map(Map.Entry::getKey)
				.toList();
	}
	
	private void checkVariable(String name, Class<?> type) {
		if (this.variableType.containsKey(name) && !this.variableType.get(name).equals(type)) {
			throw new IllegalArgumentException("Variable " + name + " is already defined as another type");
		}
	}
}
