package com.nice.dcm.simulation.distribution.node;

import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleSet;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class ExecutionImpl implements Execution {
	private final RoutingRuleSet routingRuleSet;
	
	@Override
	public String toExpression() {
		return routingRuleSet.toExpression();
	}
}
