package com.nice.dcm.simulation.distribution.node.rule.skill;

import com.nice.dcm.simulation.distribution.node.BaseNode;

public enum SqlOperator implements BaseNode {
    IN("in") {
    	@Override
		public boolean evaluate(int left, int upperBound, int lowerBound) {
			return left >= lowerBound && left <= upperBound;
		}
    }, 
    
    NOT_IN("not in") {
		@Override
		public boolean evaluate(int left, int upperBound, int lowerBound) {
			return !IN.evaluate(left, upperBound, lowerBound);
		}
    },
    NOT_USED("");
	
	private String operator;

    SqlOperator(String operator) {
        this.operator = operator.toLowerCase();
    }
    
    public String getOperator() {
        return operator;
    }	
    
    public boolean evaluate(int left, int upperBound, int lowerBound) {
        throw new IllegalArgumentException("Unknown operator: " + this);
    }

    public static SqlOperator fromString(String operator) {
        switch (operator.toLowerCase()) {
        case "in":
            return IN;
        case "not in":
            return NOT_IN;
        default:
            throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

	@Override
	public String toExpression() {
		return this.operator;
	}    
}
