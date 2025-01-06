package com.nice.antlr.ifstatement.node.ifstatement;

import com.nice.antlr.ifstatement.node.action.DoAction;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class ElseIfStatementImpl implements ElseIfStatement {
	private final Condition condition;
	private final DoAction action;

	public ElseIfStatementImpl(@NonNull Condition condition, @NonNull DoAction action) {
		this.condition = condition;
		this.action = action;
	}
	
	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("elseif ").append(this.condition.toExpression())
		.append(" {\n    ").append(action.toExpression())
		.append("\n}\n");
		return sb.toString();
	}
	
	@Override
	public DoAction eval(@NonNull VariableStack variableStack) {
		if (this.condition.eval(variableStack).booleanValue()) {
			if(isDebugEnable()) {
				debug("ElseIf " + this.condition.toExpression() + " = true; DO ", this.action.toExpression());
			}
			return this.action;
		} else {
			if (isDebugEnable()) {
				debug("ElseIf " + this.condition.toExpression() + " = false");
			}
		}
		return null;
	}
}
