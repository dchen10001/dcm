package com.nice.dcm.simulation.distribution.action;

public interface QueueToTarget {
	int getPriority();
	
	int getSkillSelectorId();
	
	boolean isLeastBusy();
}
