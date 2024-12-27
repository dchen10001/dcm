package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.BinaryOp;

import lombok.ToString;

@ToString
public class ConditionImpl implements Condition {
	private BinaryOp operator;
	private Expression left;
	private Expression right;

	public ConditionImpl(BinaryOp operator, Expression left, Expression right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean eval(VariableStack variableStack) {
		double leftValue = left.eval(variableStack);
		double rightValue = right.eval(variableStack);
		boolean flag = this.operator.eval(leftValue, rightValue);
		if(Execution.isDebugEnable()) {
			Execution.debug(toExpression(), String.valueOf(flag));
		}
		return flag;
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();

		if (this.left.multiVariable()) {
			sb.append("(").append(left.toExpression()).append(")");
		} else {
			sb.append(left.toExpression());
		}

		sb.append(this.operator.getSymbol());
		if (this.right.multiVariable()) {
			sb.append("(").append(right.toExpression()).append(")");
		} else {
			sb.append(right.toExpression());
		}

		return sb.toString();
	}
}
