package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.IntNodeImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for PRIORITY node priority: priority of the node
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class PriorityNodeWrapImpl implements NodeWrapper<IntNodeImpl> {
	private final int priority;

	@Override
	public IntNodeImpl getNode() {
		return new IntNodeImpl(priority);
	}
}
