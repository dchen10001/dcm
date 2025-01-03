package com.nice.antlr.ifstatement.node.ifstatement;

import java.util.List;

import com.nice.antlr.ifstatement.node.action.Action;
import com.nice.antlr.ifstatement.node.condition.Condition;
import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public class IfStatementImpl implements IfStatement {
	private final Condition condition;

	private final Action action;

	private final Action elseAction;

	private final List<ElseIfStatement> elseIfStatements;

	public IfStatementImpl(@NonNull Condition condition, @NonNull Action action, @NonNull Action elseAction,
			@NonNull List<ElseIfStatement> elseIfStatements) {
		this.condition = condition;
		this.action = action;
		this.elseAction = elseAction;
		this.elseIfStatements = elseIfStatements;
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("if ").append(this.condition.toExpression())
			.append(" {\n    ")
			.append(this.action.toExpression())
			.append("\n}\n");
		
		for(ElseIfStatement elseIfStatement : elseIfStatements) {
			sb.append(elseIfStatement.toExpression());
		}
		
        sb.append("else {\n    ")
        .append(this.elseAction.toExpression()).append("\n}\n");
		return sb.toString();
	}

	@Override
	public Action eval(@NonNull VariableStack variableStack) {
		if (this.condition.eval(variableStack).booleanValue()) {
			if (isDebugEnable()) {
				debug("If return", this.action.toExpression());
			}
			return this.action;
		}

		for (ElseIfStatement elseIfStatement : elseIfStatements) {
			Action elseIfAction = elseIfStatement.eval(variableStack);
			if (elseIfAction != null) {
				return elseIfAction;
			}
		}
		
		if (isDebugEnable()) {
			debug("Else return", this.elseAction.toExpression());
		}
		return this.elseAction;
	}
}
