package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.ifstatement.IfStatement;

import lombok.Getter;

@Getter
public class IfStatementWrapperImpl implements NodeWrapper<IfStatement> {

	private final IfStatement ifStatement;
	
	public IfStatementWrapperImpl(IfStatement ifStatement) {
		this.ifStatement = ifStatement;
	}
	
	@Override
	public IfStatement getNode() {
		return this.ifStatement;
	}
}
