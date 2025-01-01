package com.nice.antlr.function.parser.visit.nodewrapper;

import com.nice.antlr.function.node.assignment.Assignment;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AssignmentWrapperImpl implements NodeWrapper<Assignment<?>> {
	private final Assignment<?> assignment;

	public AssignmentWrapperImpl(Assignment<?> assignment) {
		this.assignment = assignment;
	}

	@Override
	public Assignment<?> getNode() {
		return this.getAssignment();
	}
}
