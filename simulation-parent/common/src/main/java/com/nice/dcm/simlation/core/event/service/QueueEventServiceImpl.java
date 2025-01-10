package com.nice.dcm.simlation.core.event.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.simlation.core.event.TimeEvent;
import com.nice.dcm.simlation.core.event.TimeEventImpl;

import lombok.NonNull;

public class QueueEventServiceImpl<E> implements EventService<Integer, E> {
	Logger logger = LoggerFactory.getLogger(QueueEventServiceImpl.class);

	public static final long DEFAULT_TIMEOUT = 1000; // 10ms
	
	// Event Queue
	private final BlockingQueue<TimeEvent<E>> blockingQueue = new LinkedBlockingDeque<>();

	// Event Queue Listener
	private EventListener<E> listener;
	
    private final ExecutorService executor;
    
    private final int maxSession;
	// Current Time
	private long currentTime;
	
	public QueueEventServiceImpl(@NonNull EventListener<E> listener, int maxSession) {
		this.listener = listener;
		this.maxSession = maxSession;
		if (this.maxSession > 1) {
			this.executor = Executors.newFixedThreadPool(maxSession);
		} else {
			this.executor =  Executors.newSingleThreadExecutor();
		}
	}

	@Override
	public Integer start(long currentTime, @NonNull List<E> events) {
		logger.debug("Start Event Service at currentTime: {}", currentTime);
		if (this.currentTime != currentTime && !blockingQueue.isEmpty()) {
			throw new IllegalStateException("Queue is not empty");
		}
		
		this.currentTime = currentTime;
		shuffle(events).forEach(this::offer);
		
		//start listener
		Queue<Future<?>> eventStatus = runListener();
		// wait for all events to complete
		return checkStatus(eventStatus);
	}
	
	private List<E> shuffle(List<E> events) {
		if (events.size() <= 1) {
			return events;
		}
		
		List<E> eventsCopy = new ArrayList<>(events);
		Collections.shuffle(eventsCopy);
		return eventsCopy;
	}
	
	protected Queue<Future<?>> runListener() {
		Queue<Future<?>> eventStatus = new LinkedList<>();
		while (!blockingQueue.isEmpty()) {
			TimeEvent<E> e = blockingQueue.poll();
			Future<?> f = executor.submit(() -> {
				listener.onEvent(e);
			});
			eventStatus.add(f);
		}
		return eventStatus;
	}
	
	private int checkStatus(Queue<Future<?>> eventStatus) {
		int eventCount = 0;
		Future<?> f;
		while(!eventStatus.isEmpty()) {
			f = eventStatus.poll();
			eventCount++;
			if (!f.isDone()) {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					Thread.currentThread().interrupt();
					logger.warn("Exception while checking status", e);
				}
			}
		}	
		return eventCount;
	}
	
	/**
	 * @return the queue size
	 */
	public int size() {
		return blockingQueue.size();
	}
	
	protected boolean offer(E event) {
		TimeEvent<E> timeEvent = new TimeEventImpl<>(currentTime, event);
		logger.debug("Push Time Event to queue. Id : {}, event: {}", timeEvent.getEventId(), event);
		return blockingQueue.offer(timeEvent);
	}
}
