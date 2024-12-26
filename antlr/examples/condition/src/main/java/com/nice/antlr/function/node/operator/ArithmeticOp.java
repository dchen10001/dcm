package com.nice.antlr.function.node.operator;

import java.util.EnumMap;
import java.util.function.BinaryOperator;

public enum ArithmeticOp {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), MOD("%"), POWER("^");

	private static EnumMap<ArithmeticOp, BinaryOperator<Double>> operators = new EnumMap<>(ArithmeticOp.class);
	static {
		operators.put(ArithmeticOp.PLUS, (x, y) -> x + y);
		operators.put(ArithmeticOp.MINUS, (x, y) -> x - y);
		operators.put(ArithmeticOp.MULTIPLY, (x, y) -> x * y);
		operators.put(ArithmeticOp.DIVIDE, (x, y) -> x / y);
		operators.put(ArithmeticOp.MOD, (x, y) -> x % y);
		operators.put(ArithmeticOp.POWER,  Math::pow);
	}
	
	private final String symbol;

	ArithmeticOp(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static ArithmeticOp fromSymbol(String symbol) {
		for (ArithmeticOp operator : values()) {
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
