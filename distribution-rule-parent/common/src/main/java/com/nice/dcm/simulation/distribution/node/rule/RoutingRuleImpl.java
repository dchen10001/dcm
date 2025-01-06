package com.nice.dcm.simulation.distribution.node.rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.nice.dcm.simulation.distribution.node.rule.QueueStatus;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRule;
import com.nice.dcm.simulation.distribution.node.rule.RuleAction;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Routing rule implementation.
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
public class RoutingRuleImpl implements RoutingRule {
	private final RuleAction action;
	private final QueueStatus queueStatus;
	private final List<SkillSetSelector> selectors;
	private final int priority;
	
	public RoutingRuleImpl(RuleAction action, QueueStatus queueStatus, 
			Collection<SkillSetSelector> selectors,
			int priority) {
		super();
		if (selectors == null || selectors.isEmpty()) {
			throw new IllegalArgumentException("selectors is null or empty");
		}
		
		if (priority < 0) {
			throw new IllegalArgumentException("priority is negative");
		}
		
		this.action = action == null ? RuleAction.QUEUE_TO : action;
		this.queueStatus = selectors.size() == 1 ? null : queueStatus;
		this.selectors = new ArrayList<>(selectors);
		this.priority = priority;
	}
	
	public RoutingRuleImpl(QueueStatus queueStatus, Collection<SkillSetSelector> selectors, int priority) {
		this(RuleAction.QUEUE_TO, queueStatus, selectors, priority);
	}
	
	public RoutingRuleImpl(Collection<SkillSetSelector> selectors, int priority) {
		this(null, selectors, priority);
	}

	@Override
	public boolean isLeastBusyOf() {
		return this.queueStatus != null;
	}
	
	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append(action.toExpression());
		if (queueStatus != null) {
			sb.append(" ").append(queueStatus.toExpression());
		}
		
		boolean first = true;
		for (SkillSetSelector selector : selectors) {
			if (!first) {
				sb.append("AND");
			}
			sb.append(" ").append(selector.toExpression()).append(" ");
			first = false;
		}
		
		sb.append(" ").append(priority);
		return sb.toString();
	}	
}
