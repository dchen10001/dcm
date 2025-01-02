package com.nice.antlr.ifstatement.node.condition;

import com.nice.antlr.ifstatement.node.operator.BinarySign;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

public class SignConditionImpl implements Condition {
	private BinarySign sign;
	
	private Condition condition;
	
	public SignConditionImpl(BinarySign sign, Condition condition) {
		this.sign = sign;
		this.condition = condition;
	}
	
	@Override
	public Boolean eval(VariableStack variableStack) {
		boolean flag = sign.eval(condition.eval(variableStack));
		if(isDebugEnable()) {
			debug(toExpression(), String.valueOf(flag));
		}
		return flag;
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
