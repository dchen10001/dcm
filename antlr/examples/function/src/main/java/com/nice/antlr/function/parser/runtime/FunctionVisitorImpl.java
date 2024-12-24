package com.nice.antlr.function.parser.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.function.parser.FunctionBaseVisitor;
import com.nice.antlr.function.parser.FunctionParser;
import com.nice.antlr.function.parser.FunctionParser.ADDOPGRPContext;
import com.nice.antlr.function.parser.FunctionParser.DOUBLEContext;
import com.nice.antlr.function.parser.FunctionParser.MULOPGRPContext;
import com.nice.antlr.function.parser.FunctionParser.MulopContext;
import com.nice.antlr.function.parser.FunctionParser.PARENGRPContext;
import com.nice.antlr.function.parser.FunctionParser.UMINUSContext;
import com.nice.antlr.function.parser.node.FunctionNode;

public class FunctionVisitorImpl extends FunctionBaseVisitor<Double> {
	protected static final Logger logger = LoggerFactory.getLogger(FunctionVisitorImpl.class);

	private Map<String, BinaryOperator<Double>> operatorMap;

	private Map<String, Double> variableMap = new HashMap<>();

	public FunctionVisitorImpl() {
		createOperationMap();
	}

	public void setVariable(String variable, Double value) {
		variableMap.put(variable, value);
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
	public Double visitStart(FunctionParser.StartContext ctx) {
		logger.debug("Visiting start: {}", ctx.getText());
		Double d = super.visitStart(ctx);
		logger.debug("Visiting start result: {}", d);
		return d;
	}

	@Override
	public Double visitUMINUS(UMINUSContext ctx) {
		logger.debug("Visiting uminus: {}", ctx.getText());
		Double d = -1 * visit(ctx.expr());
		logger.debug("Visiting uminus result: {}", d);
		return d;
	}

	@Override
	public Double visitMULOPGRP(MULOPGRPContext ctx) {
		logger.debug("Visiting mulopgrp: {}", ctx.getText());
		String op = ctx.mulop().getText();
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		Double d = eval(op, left, right);
		logger.debug("Visiting mulopgrp result: {}", d);
		return d;
	}

	@Override
	public Double visitADDOPGRP(ADDOPGRPContext ctx) {
		logger.debug("Visiting addopgrp: {}", ctx.getText());
		String op = ctx.addop().getText();
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		Double d = eval(op, left, right);
		logger.debug("Visiting addopgrp result: {}", d);
		return d;
	}

	@Override
	public Double visitPARENGRP(PARENGRPContext ctx) {
		logger.debug("Visiting parengroup: {}", ctx.getText());
		Double d = visit(ctx.expr());
		logger.debug("Visiting parengroup result: {}", d);
		return d;
	}

	@Override
	public Double visitChildren(RuleNode node) {
		logger.debug("Visiting children: {}", node.getText());
		return super.visitChildren(node);
	}
	
	@Override
	public Double visitAddop(FunctionParser.AddopContext ctx) {
		logger.debug("Visiting addop: {}", ctx.getText());
		Double d = super.visitAddop(ctx);
		logger.debug("Visiting addop result: {}", d);
		return d;
	}

	@Override
	public Double visitMulop(MulopContext ctx) {
		logger.debug("Visiting mulop: {}", ctx.getText());
		Double d = super.visitMulop(ctx);
		logger.debug("Visiting mulop result: {}", d);
		return d;
	}
	
	@Override
	public Double visitDOUBLE(DOUBLEContext ctx) {
		logger.debug("Visiting double: {}", ctx.getText());
		Double d = Double.valueOf(ctx.NUMBER().getText());
		logger.debug("Visiting double result: {}", d);
		return d;
	}

	@Override
	public Double visitVARIABLE(FunctionParser.VARIABLEContext ctx) {
		logger.debug("Visiting variable: {}", ctx.getText());
		String variable = ctx.Identifier().getText();
		if (variableMap.containsKey(variable)) {
			Double d = variableMap.get(variable);
			logger.debug("Visiting variable variable: {}", variable);
			return d;
		} else {
			throw new IllegalArgumentException("Variable not found: " + variable);
		}
	}
}
