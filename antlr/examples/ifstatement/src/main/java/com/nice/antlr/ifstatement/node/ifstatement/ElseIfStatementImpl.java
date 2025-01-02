package com.nice.antlr.ifstatement.node.ifstatement;

import com.nice.antlr.ifstatement.node.action.Action;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.Getter;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Getter
public class ElseIfStatementImpl implements ElseIfStatement {
	private final Condition condition;
	private final Action action;

	public ElseIfStatementImpl(@NonNull Condition condition, @NonNull Action action) {
		this.condition = condition;
		this.action = action;
	}
	
	@Override
	public String toExpression() {
		return "ELSEIF" + this.condition.toExpression() + "\n" 
				+ this.action.toExpression();
	}
	
	@Override
	public Action eval(@NonNull VariableStack variableStack) {
		if (this.condition.eval(variableStack).booleanValue()) {
			return this.action;
		}
		return null;
	}
}
