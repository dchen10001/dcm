package com.nice.dcm.simlation.core.event.service;

import java.util.List;

public interface EventService<T, E> {
	
    /**
     * start the event service at the time. Any event must be in the same time.
     * @param currentTime
     * @return
     */
    public T start(long currentTime, List<E> events);
}
