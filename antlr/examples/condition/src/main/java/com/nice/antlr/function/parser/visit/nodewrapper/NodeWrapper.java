package com.nice.antlr.function.parser.visit.nodewrapper;

import com.nice.antlr.function.node.BaseNode;

public interface NodeWrapper<T extends BaseNode<?>> {
	T getNode();
}
