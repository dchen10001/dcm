package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.action.Action;

import lombok.Getter;

@Getter
public class ActionWrapperImpl implements NodeWrapper<Action> {

	private final Action action;

	public ActionWrapperImpl(Action action) {
		this.action = action;
	}

	@Override
	public Action getNode() {
		return this.action;
	}
}
