package com.nice.antlr.ifstatement.parser.visit.nodewrapper;

import com.nice.antlr.ifstatement.node.BaseNode;

public interface NodeWrapper<T extends BaseNode> {
	T getNode();
}
