package com.nice.dcm.simulation.distribution.action;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Queue to action implementation.
 * 
 * @see QueueToAction
 * 
 * @author David Chen
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
public class QueueToActionImpl implements QueueToAction {
	private final Set<SkillQueueSelector> selectors;
	private final int priority;
	private final boolean leastBusy;
	
	public QueueToActionImpl(@NonNull List<SkillQueueSelector> skillSelectors, int priority, boolean leastBusy) {
		if (skillSelectors.isEmpty()) {
			throw new IllegalArgumentException("skillSelectors is null or empty");
		}
		
		if (priority < 0) {
			throw new IllegalArgumentException("priority is less than 0");
		}
		
		this.selectors = skillSelectors.stream().distinct().collect(Collectors.toSet());
		this.priority = priority;
		this.leastBusy = leastBusy;
	}

	@Override
	public int compareTo(QueueToAction o) {
		if (priority > o.getPriority())
			return 1;
		else if (priority < o.getPriority())
			return -1;
		else
			return 0;
	}

	@Override
	public String toExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue To");
		if (leastBusy) {
			sb.append(" ").append("Least Busy of ");
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
