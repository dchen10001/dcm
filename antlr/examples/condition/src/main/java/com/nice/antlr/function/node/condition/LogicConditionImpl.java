package com.nice.antlr.function.node.condition;

import com.nice.antlr.function.node.operator.LogicOp;
import com.nice.antlr.function.node.variable.VariableStack;

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
	public Boolean eval(VariableStack variableStack) {
		boolean flag =  operator.eval(variableStack, left, right);
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(flag));
		}
		return flag;
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
