package com.nice.dcm.simlation.core.event.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.simlation.core.event.TimeEvent;
import com.nice.dcm.simlation.core.event.TimeEventImpl;

import lombok.NonNull;

public class SequeueEventServiceImpl<E> implements EventService<Integer, E> {
	Logger logger = LoggerFactory.getLogger(SequeueEventServiceImpl.class);

	// Event Queue Listener
	private EventListener<E> listener;

	// Current Time
	private long currentTime;

	public SequeueEventServiceImpl(EventListener<E> listener) {
		this.listener = listener;
	}

	protected void offer(long currentTime, @NonNull List<E> events) {

	}

	private TimeEvent<E> toTimeEvent(E event) {
		return new TimeEventImpl<>(currentTime, event);
	}

	@Override
	public Integer start(long currentTime, @NonNull List<E> events) {
		this.currentTime = currentTime;
		List<TimeEvent<E>> timeEvents = events.stream().map(this::toTimeEvent).toList();
		if (timeEvents == null || timeEvents.isEmpty()) {
			return 0;
		}
		Collections.shuffle(timeEvents);
		timeEvents.forEach(listener::onEvent);
		return timeEvents.size();
	}
}
