package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleSet;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class RoutingRuleSetNodeWrapImpl implements NodeWrapper<RoutingRuleSet> {
	private final RoutingRuleSet routingRuleSet;

	@Override
	public RoutingRuleSet getNode() {
		return routingRuleSet;
	}	
}
