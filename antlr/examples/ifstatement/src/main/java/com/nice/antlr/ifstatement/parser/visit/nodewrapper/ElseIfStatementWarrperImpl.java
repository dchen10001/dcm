package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.ifstatement.ElseIfStatement;

import lombok.Getter;

@Getter
public class ElseIfStatementWarrperImpl implements NodeWrapper<ElseIfStatement> {
	private final ElseIfStatement elseIfStatement;

	public ElseIfStatementWarrperImpl(ElseIfStatement elseIfStatement) {
		this.elseIfStatement = elseIfStatement;
	}

	@Override
	public ElseIfStatement getNode() {
		return elseIfStatement;
	}

}
