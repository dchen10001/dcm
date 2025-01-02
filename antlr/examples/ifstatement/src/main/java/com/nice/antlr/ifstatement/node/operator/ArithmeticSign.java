package com.nice.antlr.ifstatement.node.operator;

import java.util.EnumMap;
import java.util.function.DoubleFunction;

public enum ArithmeticSign {
	UMINUS("-"), NOT("!"), ABS("abs"), LN("ln"), SIN("sin"), COS("cos"), TAN("tan"), SQRT("sqrt");
	
	private static EnumMap<ArithmeticSign, DoubleFunction<Double>> operators = new EnumMap<>(ArithmeticSign.class);
	static {
		operators.put(ArithmeticSign.UMINUS,  (x) -> -x);
		operators.put(ArithmeticSign.NOT,  (x) -> {return x == 0 ? 1.0 : 0.0;});
		operators.put(ArithmeticSign.ABS, Math::abs);
		operators.put(ArithmeticSign.ABS, Math::abs);
		operators.put(ArithmeticSign.LN, Math::log);
		operators.put(ArithmeticSign.SIN, Math::sin);
		operators.put(ArithmeticSign.COS, Math::cos);
		operators.put(ArithmeticSign.TAN, Math::tan);
		operators.put(ArithmeticSign.SQRT, Math::sqrt);
	}
	
	private final String symbol;
	
	ArithmeticSign(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public Double eval(Double value) {
		return operators.get(this).apply(value);
	}
	
	public static ArithmeticSign fromSymbol(String symbol) {
		for (ArithmeticSign sign : values()) {
			if (sign.symbol.equals(symbol)) {
				return sign;
			}
		}
		throw new IllegalArgumentException("Unknown operator: " + symbol);
	}
}
