package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.Operator;
import com.nice.antlr.function.node.operator.SignOperator;

import lombok.ToString;

@ToString
public class ExpressionNodeImpl implements ExpressionNode {
	private SignOperator sign;
	private Operator operator;
	private ExpressionNode left;
	private ExpressionNode right;
	
	public ExpressionNodeImpl(Operator operator, ExpressionNode left, ExpressionNode right) {
		this(null, operator, left, right);
	}
	
	public ExpressionNodeImpl(SignOperator sign, Operator operator, ExpressionNode left, ExpressionNode right) {
		this.sign = sign;
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void setSign(SignOperator operator) {
		this.sign = operator;
	}
	
	public double eval() {
        return eval(null);
	}

	@Override
	public double eval(VariableStack variableStack) {
        double leftValue = left.eval(variableStack);
        double rightValue = right.eval(variableStack);
        double value = operator.eval(leftValue, rightValue);
        if(sign != null) {
        	return sign.eval(value);
        }
        return value;
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		if (sign != null) {
			sb.append(sign.getSymbol()).append("(");
		}
		
		boolean flag = this.operator == Operator.MOD || this.operator == Operator.DIVIDE || this.operator == Operator.MULTIPLY;
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
