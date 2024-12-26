package com.nice.antlr.function.node.operator;

public enum BinarySign {
	NOT("!");
	
	private final String symbol;
	
	BinarySign(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public boolean eval(boolean value) {
		return !value;
	}
	
	public static BinarySign fromSymbol(String symbol) {
		for (BinarySign sign : values()) {
			if (sign.symbol.equals(symbol)) {
				return sign;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
}
