package com.nice.dcm.distribution.rule.parser.visit.nodewrapper;

import com.nice.dcm.simulation.distribution.node.BaseNode;

public interface NodeWrapper <T extends BaseNode> {
	T getNode();
}
