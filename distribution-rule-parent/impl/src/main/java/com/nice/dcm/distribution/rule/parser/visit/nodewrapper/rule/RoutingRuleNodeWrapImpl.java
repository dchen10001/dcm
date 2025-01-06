package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRule;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for ROUTINGRULE node routingRule: RoutingRule instance
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class RoutingRuleNodeWrapImpl implements NodeWrapper<RoutingRule> {
	private final RoutingRule routingRule;

	@Override
	public RoutingRule getNode() {
		return routingRule;
	}
}
