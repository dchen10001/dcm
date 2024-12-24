package com.nice.antlr.function.node.operator;

import java.util.EnumMap;
import java.util.function.BinaryOperator;

public enum Operator {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), MOD("%"), POWER("^");

	private static EnumMap<Operator, BinaryOperator<Double>> operators = new EnumMap<>(Operator.class);
	static {
		operators.put(Operator.PLUS, (x, y) -> x + y);
		operators.put(Operator.MINUS, (x, y) -> x - y);
		operators.put(Operator.MULTIPLY, (x, y) -> x * y);
		operators.put(Operator.DIVIDE, (x, y) -> x / y);
		operators.put(Operator.MOD, (x, y) -> x % y);
		operators.put(Operator.POWER,  Math::pow);
	}
	
	private final String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Operator fromSymbol(String symbol) {
		for (Operator operator : values()) {
			if (operator.symbol.equals(symbol)) {
				return operator;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
	
	public Double eval(Double left, Double right) {
		return operators.get(this).apply(left, right);
	}	
}
