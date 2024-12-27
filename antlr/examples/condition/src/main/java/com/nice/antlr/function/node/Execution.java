package com.nice.antlr.function.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Execution {
	static final Logger logger = LoggerFactory.getLogger(Execution.class);
	static boolean isDebugEnable() {
		return logger.isDebugEnabled();
	}
	
	static void debug(String script, String value) {
		logger.debug("{} : {}", script, value);
	}

	
	boolean eval(VariableStack variableStack);
	String toExpression();
}
