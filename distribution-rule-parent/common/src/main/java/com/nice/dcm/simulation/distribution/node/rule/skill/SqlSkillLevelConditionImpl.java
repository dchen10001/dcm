package com.nice.dcm.simulation.distribution.node.rule.skill;

import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SqlSkillLevelConditionImpl implements SkillLevelCondition {
	private final SqlOperator operator;
	private final int lowerBound;
	private final int upperBound;

	public SqlSkillLevelConditionImpl(@NonNull SqlOperator operator, int lowerBound, int upperBound) {
		if (lowerBound < 0) {
			throw new IllegalArgumentException("lowerBound is negative");
		}

		if (lowerBound > upperBound) {
			throw new IllegalArgumentException("upperBound is less than lowerBound");
		}
		
		this.operator = operator;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public boolean evaluate(int level) {
		boolean flag = operator.evaluate(level, upperBound, lowerBound);
		debug(toExpression(), "=", String.valueOf(flag));
		return flag;
	}

	@Override
	public int compareTo(SkillLevelCondition o) {
		if (o == null) {
			return 1;
		}

		if (o instanceof SqlSkillLevelConditionImpl other) {
			if (operator != other.operator) {
				return operator.compareTo(other.operator);
			}
			if (lowerBound != other.lowerBound) {
				return Integer.compare(lowerBound, other.lowerBound);
			}
			return Integer.compare(upperBound, other.upperBound);
		} else {
			return -1;
		}
	}

	@Override
	public String toExpression() {
		return "level " + this.operator.toExpression() + " " + this.lowerBound + " .. " + this.upperBound;
	}
}
