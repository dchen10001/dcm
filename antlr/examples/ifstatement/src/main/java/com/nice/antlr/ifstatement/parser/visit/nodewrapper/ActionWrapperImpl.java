package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.action.DoAction;

import lombok.Getter;

@Getter
public class ActionWrapperImpl implements NodeWrapper<DoAction> {

	private final DoAction action;

	public ActionWrapperImpl(DoAction action) {
		this.action = action;
	}

	@Override
	public DoAction getNode() {
		return this.action;
	}
}
