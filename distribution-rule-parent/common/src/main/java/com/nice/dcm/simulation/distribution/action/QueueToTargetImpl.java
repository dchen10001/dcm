package com.nice.dcm.simulation.distribution.action;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class QueueToTargetImpl implements QueueToTarget {
	private final int skillSelectorId;
	private final int priority;
	private final boolean leastBusy;
}
