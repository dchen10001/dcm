package com.nice.antlr.function.parser.visit.nodewrapper;

import com.nice.antlr.function.node.Execution;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExecutionWrapperImpl implements NodeWrapper<Execution> {
	private final Execution execution;
	
	public ExecutionWrapperImpl(Execution execution) {
		this.execution = execution;
	}
	
	@Override
	public Execution getNode() {
		return this.getExecution();
	}
}
