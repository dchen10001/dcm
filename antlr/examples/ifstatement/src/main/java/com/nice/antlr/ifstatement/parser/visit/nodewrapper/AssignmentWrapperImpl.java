package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.assignment.Assignment;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Getter
public class AssignmentWrapperImpl implements NodeWrapper<Assignment<?>> {
	private final Assignment<?> assignment;

	public AssignmentWrapperImpl(@NonNull Assignment<?> assignment) {
		this.assignment = assignment;
	}

	@Override
	public Assignment<?> getNode() {
		return this.getAssignment();
	}
}
