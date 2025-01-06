package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.RuleAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for ACTIONRULE node action: action to be performed
 * only QUEUE_TO supported at the moment
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class ActionNodeWrapImpl implements NodeWrapper<RuleAction> {
	private final RuleAction action;
	
	@Override
	public RuleAction getNode() {
		return this.action;
	}
}
