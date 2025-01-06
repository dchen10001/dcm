package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.RoutingGroupRule;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class RoutingRuleGroupNodeWrapImpl implements NodeWrapper<RoutingGroupRule> {
	
	private final RoutingGroupRule routingGroupRule;

	@Override
	public RoutingGroupRule getNode() {
		return routingGroupRule;
	}
}
