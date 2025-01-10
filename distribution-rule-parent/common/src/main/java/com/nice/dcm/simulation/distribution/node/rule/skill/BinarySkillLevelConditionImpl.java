package com.nice.dcm.simulation.distribution.node.rule.skill;

import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public class BinarySkillLevelConditionImpl implements SkillLevelCondition {
    private final BinaryOperator operator;
    private final int right;
    
    public BinarySkillLevelConditionImpl(@NonNull BinaryOperator operator, int right) {
		if (right < 0) {
			throw new IllegalArgumentException("right is negative");
		}
		
        this.operator = operator;
        this.right = right;
    }
    
	@Override
	public boolean evaluate(int left) {
		boolean flag = operator.evaluate(left, right);
		debug(toExpression(), "=", String.valueOf(flag));
		return flag;
	}
	
	@Override
	public int compareTo(SkillLevelCondition o) {
        if (o == null) {
            return 1;
        }
        
        if (o instanceof BinarySkillLevelConditionImpl other) {
            if (operator != other.operator) {
                return operator.compareTo(other.operator);
            }
            return Integer.compare(right, other.right);
        } else {
            return 1;
        }
	}

	@Override
	public String toExpression() {
		return "level " + this.operator.toExpression() + " " + this.right;
	}
}
