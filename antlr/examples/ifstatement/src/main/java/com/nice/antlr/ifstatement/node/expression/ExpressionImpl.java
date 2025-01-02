package com.nice.antlr.ifstatement.node.expression;

import com.nice.antlr.ifstatement.node.operator.ArithmeticOp;
import com.nice.antlr.ifstatement.node.operator.ArithmeticSign;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.ToString;

@ToString
public class ExpressionImpl implements Expression {
	private final ArithmeticSign sign;
	private final ArithmeticOp operator;
	private final Expression left;
	private final Expression right;
	
	public ExpressionImpl(ArithmeticOp operator, Expression left, Expression right) {
		this(null, operator, left, right);
	}
	
	public ExpressionImpl(ArithmeticSign sign, ArithmeticOp operator, Expression left, Expression right) {
		this.sign = sign;
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	public double eval() {
        return eval(null);
	}

	@Override
	public Double eval(VariableStack variableStack) {
        double leftValue = left.eval(variableStack);
        double rightValue = right.eval(variableStack);
        double value = operator.eval(leftValue, rightValue);       
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(value));
		}
        return value;
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		if (sign != null) {
			sb.append(sign.getSymbol()).append("(");
		}
		
		boolean flag = this.operator == ArithmeticOp.MOD || this.operator == ArithmeticOp.DIVIDE || this.operator == ArithmeticOp.MULTIPLY;
		if (flag && this.left.multiVariable()) {
			sb.append("(").append(left.toExpression()).append(")");
		} else {
			sb.append(left.toExpression());
		}
		sb.append(this.operator.getSymbol());
		if (flag && this.right.multiVariable()) {
			sb.append("(").append(right.toExpression()).append(")");
		} else {
			sb.append(right.toExpression());
		}		
		
		if (sign != null) {
			sb.append(")");
		}
		return sb.toString();
	}
	
	@Override
	public boolean multiVariable() {
		return this.left != null && this.right != null;
	}
}
