package com.nice.antlr.experssion.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class ExpressionVisitorImpl extends ExpressionBaseVisitor<Double> {
	private Map<String, BinaryOperator<Double>> operatorMap;

	public ExpressionVisitorImpl() {
		createOperationMap();
	}

	private void createOperationMap() {
		operatorMap = new HashMap<>();

		operatorMap.put("+", Double::sum);
		operatorMap.put("-", (x, y) -> x - y);
		operatorMap.put("*", (x, y) -> x * y);
		operatorMap.put("/", (x, y) -> x / y);
		operatorMap.put("%", (x, y) -> x % y);
	}

	private Double eval(String op, Double left, Double right) {
		return operatorMap.get(op).apply(left, right);
	}

	@Override
	public Double visitUMINUS(ExpressionParser.UMINUSContext ctx) {
		return -1 * visit(ctx.expr());
	}

	@Override
	public Double visitMULOPGRP(ExpressionParser.MULOPGRPContext ctx) {
		String op = ctx.mulop().getText();
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		return eval(op, left, right);
	}

	@Override
	public Double visitADDOPGRP(ExpressionParser.ADDOPGRPContext ctx) {
		String op = ctx.addop().getText();
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		return eval(op, left, right);
	}

	@Override
	public Double visitPARENGRP(ExpressionParser.PARENGRPContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public Double visitDOUBLE(ExpressionParser.DOUBLEContext ctx) {
		return Double.valueOf(ctx.NUMBER().getText());
	}
}
