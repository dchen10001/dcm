package com.nice.dcm.simlation.core.event.service;

import com.nice.dcm.simlation.core.event.TimeEvent;

public interface EventListener<E> {
	void onEvent(TimeEvent<E> element);
}
