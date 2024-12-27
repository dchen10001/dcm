package com.nice.antlr.function.node;

import com.nice.antlr.function.node.operator.BinarySign;

public class SignConditionImpl implements Condition {
	private BinarySign sign;
	
	private Condition condition;
	
	public SignConditionImpl(BinarySign sign, Condition condition) {
		this.sign = sign;
		this.condition = condition;
	}
	
	@Override
	public boolean eval(VariableStack variableStack) {
		return sign.eval(condition.eval(variableStack));
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append(sign.getSymbol())
			.append("(")
			.append(condition.toExpression())
			.append(")");
		return sb.toString();
	}

}
