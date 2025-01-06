package com.nice.dcm.simulation.distribution.node.rule;

import com.nice.dcm.simulation.distribution.node.BaseNode;

/**
 * RuleAction enum defines Rule's Action type. 
 * 
 * DCM distribution rule only supports Queue to Action.
 * 
 * In future, it may supports Route To, or others.
 * 
 * @author David Chen
 *  
 */
public enum RuleAction implements BaseNode {
	QUEUE_TO() {
		@Override
		public String toExpression() {
			return "QUEUE TO";
		}
	};
}
