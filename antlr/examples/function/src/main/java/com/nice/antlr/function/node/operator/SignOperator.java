package com.nice.antlr.function.node.operator;

import java.util.EnumMap;
import java.util.function.DoubleFunction;

public enum SignOperator {
	UMINUS("-"), ABS("abs"), LN("ln"), SIN("sin"), COS("cos"), TAN("tan"), SQRT("sqrt");
	
	private static EnumMap<SignOperator, DoubleFunction<Double>> operators = new EnumMap<>(SignOperator.class);
	static {
		operators.put(SignOperator.UMINUS,  (x) -> -x);
		operators.put(SignOperator.ABS, Math::abs);
		operators.put(SignOperator.ABS, Math::abs);
		operators.put(SignOperator.LN, Math::log);
		operators.put(SignOperator.SIN, Math::sin);
		operators.put(SignOperator.COS, Math::cos);
		operators.put(SignOperator.TAN, Math::tan);
		operators.put(SignOperator.SQRT, Math::sqrt);
	}
	
	private final String symbol;
	
	SignOperator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public Double eval(Double value) {
		return operators.get(this).apply(value);
	}
	
	public static SignOperator fromSymbol(String symbol) {
		for (SignOperator sign : values()) {
			if (sign.symbol.equals(symbol)) {
				return sign;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
}
