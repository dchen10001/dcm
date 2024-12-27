package com.nice.antlr.function.parser.node;

import com.nice.antlr.function.node.Execution;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExecutionNodeImpl implements Node {
	private final Execution execution;
	
	public ExecutionNodeImpl(Execution execution) {
		this.execution = execution;
	}
	
	@Override
	public Object getObject() {
		return this.getExecution();
	}
}
