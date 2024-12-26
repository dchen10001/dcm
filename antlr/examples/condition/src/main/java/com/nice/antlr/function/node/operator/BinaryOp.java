package com.nice.antlr.function.node.operator;

import java.util.EnumMap;
import java.util.function.BiFunction;

public enum BinaryOp {
	EQUALS("=="), NOT_EQUALS("!="), GREATER_THAN(">"), LESS_THAN("<"), GREATER_THAN_OR_EQUAL(">="), LESS_THAN_OR_EQUAL("<=")
	;

	private static EnumMap<BinaryOp, BiFunction<Double, Double, Boolean>> operators = new EnumMap<>(BinaryOp.class);
	static {
		operators.put(BinaryOp.EQUALS, (x, y) -> x.equals(y));
		operators.put(BinaryOp.NOT_EQUALS, (x, y) -> !x.equals(y));
		operators.put(BinaryOp.GREATER_THAN, (x, y) -> x > y);
		operators.put(BinaryOp.LESS_THAN, (x, y) -> x < y);
		operators.put(BinaryOp.GREATER_THAN_OR_EQUAL, (x, y) -> x >= y);
		operators.put(BinaryOp.LESS_THAN_OR_EQUAL, (x, y) -> x <= y);
	}
	
	private final String symbol;

	BinaryOp(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static BinaryOp fromSymbol(String symbol) {
		for (BinaryOp operator : values()) {
			if (operator.symbol.equals(symbol)) {
				return operator;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
	
	public boolean eval(Double left, Double right) {
		return operators.get(this).apply(left, right);
	}	
}
