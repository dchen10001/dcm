package com.nice.antlr.function.parser.node;

import com.nice.antlr.function.node.Assignment;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AssignmentNodeImpl implements Node {
	private final Assignment assignment;

	public AssignmentNodeImpl(Assignment assignment) {
		this.assignment = assignment;
	}

	@Override
	public Object getObject() {
		return this.getAssignment();
	}
}
