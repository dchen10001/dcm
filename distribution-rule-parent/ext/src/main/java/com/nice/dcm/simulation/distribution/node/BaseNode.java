package com.nice.dcm.simulation.distribution.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseNode {
	static final Logger logger = LoggerFactory.getLogger(BaseNode.class);

	String toExpression();

	default void debug(String... messages) {
		if(!logger.isDebugEnabled()) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (String msg : messages) {
			sb.append(msg).append(" ");
		}
		logger.debug("{}", sb);
	}
}
