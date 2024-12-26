package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.BinarySign;
import com.nice.antlr.function.node.operator.LogicOp;

public class LogicConditionImpl implements Condition {
	private LogicOp operator;
	private Condition left;
	private Condition right;
	
	public LogicConditionImpl(LogicOp operator, Condition left, Condition right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean eval(VariableStack variableStack) {
		return operator.eval(variableStack, left, right);
	}

	@Override
	public boolean eval() {
		return eval(null);
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		if (this.left instanceof LogicConditionImpl) {
			sb.append("(").append(left.toExpression()).append(")");
		} else {
			sb.append(left.toExpression());
		}
		
		sb.append(this.operator.getSymbol());
		if (this.right instanceof LogicConditionImpl) {
			sb.append("(").append(right.toExpression()).append(")");
		} else {
			sb.append(right.toExpression());
		}	
		return sb.toString();
	}
}
