package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.QueueStatus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for QUEUE_STATUS node queue_status: LEAST_BUSY
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class QueueStatusNodeWrapImpl implements NodeWrapper<QueueStatus> {
	private final QueueStatus queueStatus;

	@Override
	public QueueStatus getNode() {
		return queueStatus;
	}
	
}
