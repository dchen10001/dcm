package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.LongNodeImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for WAITING node
 * waitFor: seconds to wait to process new rules
 */
@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class WaitNodeWrapImpl implements NodeWrapper<LongNodeImpl> {
	private final long waitFor;

	@Override
	public LongNodeImpl getNode() {
		return new LongNodeImpl(waitFor);
	}
}
