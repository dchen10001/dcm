package com.nice.antlr.ifstatement.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.antlr.ifstatement.node.variable.VariableStack;

import lombok.NonNull;

public interface BaseNode<T> {
	static final Logger logger = LoggerFactory.getLogger(BaseNode.class);

	String toExpression();

	default boolean isDebugEnable() {
		return logger.isDebugEnabled();
	}

	default void debug(String script, String value) {
		logger.debug("{} : {}", script, value);
	}
	
	default void debug(String msg) {
		logger.debug(msg);
	}
	
	T eval(@NonNull VariableStack variableStack);
}
