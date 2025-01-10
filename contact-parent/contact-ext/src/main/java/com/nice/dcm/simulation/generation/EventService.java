package com.nice.dcm.simulation.generation;

import java.util.List;

public interface EventService<T> {
	
	public void reset();
	
	public boolean hasNext();
	
	public long nextEventTime();
	
	public List<T> nextEvents(long currentTime);
}
