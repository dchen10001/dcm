package com.nice.dcm.simlation.core.event.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.simlation.core.event.TimeEvent;

public class EventListenerImpl<E> implements EventListener<E> {
	private static Logger logger = LoggerFactory.getLogger(EventListenerImpl.class);

	private Random random = null;
	
	public EventListenerImpl() {
		this(false);
	}
	
	public EventListenerImpl(boolean debug) {
		if (debug) {
			this.random = new Random();
		}
	}
	
	protected void processEvent(E event) {
		logger.info("Event: {}", event);
		delay(this.random);
	};
	
	@Override
	public void onEvent(TimeEvent<E> element) {
        logger.debug("currentTime: {}, Event: {} ", element.getEventTime(), element);
        
		if (element.getEvent() == null) {
			logger.error("Event is null");
			return;
		}
        processEvent(element.getEvent());
	}
	
	private void delay(Random random) {
		if(random == null) {
			return;
		}
		
		int randomNumber = random.nextInt(100) + 1;
		logger.debug("Random Number: {}", randomNumber);
		try {
            Thread.sleep(randomNumber);
        } catch (InterruptedException e) {
            logger.error("InterruptedException", e);
            Thread.currentThread().interrupt();
        }
	}
}
