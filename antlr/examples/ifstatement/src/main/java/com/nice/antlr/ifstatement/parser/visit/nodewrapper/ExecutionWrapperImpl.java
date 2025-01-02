package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.Execution;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class ExecutionWrapperImpl implements NodeWrapper<Execution> {
	private final Execution execution;
	
	public ExecutionWrapperImpl(@NonNull Execution execution) {
		this.execution = execution;
	}
	
	@Override
	public Execution getNode() {
		return this.getExecution();
	}
}
