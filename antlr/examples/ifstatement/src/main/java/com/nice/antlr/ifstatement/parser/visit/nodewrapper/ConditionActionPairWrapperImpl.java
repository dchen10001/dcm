package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatement;

import lombok.NonNull;

public class ConditionActionPairWrapperImpl implements NodeWrapper<ElseIfStatement> {
	private final ElseIfStatement elseIfStatement;
	
	public ConditionActionPairWrapperImpl(@NonNull ElseIfStatement elseIfStatement) {
		this.elseIfStatement = elseIfStatement;
	}
	
	@Override
	public ElseIfStatement getNode() {
		return this.elseIfStatement;
	}

}
