package com.nice.dcm.distribution.rule.parser.visit.nodewrapper;

import com.nice.dcm.simulation.distribution.node.Execution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ExecutionNodeWrapperImpl implements NodeWrapper<Execution> {
	private final Execution execution;
	
	@Override
	public Execution getNode() {
		return execution;
	}
}
