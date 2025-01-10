package com.nice.dcm.simlation.core.event;

import java.util.concurrent.atomic.AtomicLong;

public interface TimeEvent<E> extends Comparable<TimeEvent<E>> {
	final long INVALID_TIMESTAMP = -1;
	final AtomicLong idGenerator = new AtomicLong(0);
	
	long getEventId();
	long getEventTime();
	E getEvent();
	
	static long generateId() {
		return idGenerator.getAndIncrement();
	}
	
	static void reSetId() {
		idGenerator.set(0);
	}
	
	@Override
	default int compareTo(TimeEvent<E> o) {
		long ret = this.getEventTime() - o.getEventTime();
		if (ret == 0) {
			return 0;
		}
		return ret > 0 ? 1 : -1;
	}
}
