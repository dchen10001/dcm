package com.nice.dcm.simlation.core.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class TimeEventImpl<E> implements TimeEvent<E> {
	private final long eventId;
	private long eventTime;
	private E event;
	
	public TimeEventImpl(long eventTime, E event) {
		super();
		this.eventId = TimeEvent.generateId();
		this.eventTime = eventTime;
		this.event = event;
	}
}
