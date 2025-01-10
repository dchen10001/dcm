package com.nice.dcm.simlation.core.event.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class QueueEventServiceImplTest {

	@Test
	void testQueueService() {
		QueueEventServiceImpl<String> queueServer = getQueueEventService(5);
		
		SequeueEventServiceImpl<String> sequenceSerer =  getSequeueEventService();
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			int randomNumber = random.nextInt(100) + 1;
			List<String> events = new ArrayList<>();
			for (int j = 0; j < randomNumber; j++) {
				events.add("Event-" + j);
			}
			
			int size = queueServer.start(i, events);
			assertEquals(randomNumber, size);
			System.out.println("QueueEventServiceImplTest.testQueueService() size: " + i);
			size = sequenceSerer.start(i, events);
			assertEquals(randomNumber, size);
		}		
	}
	
	private QueueEventServiceImpl<String> getQueueEventService(int session) {
		EventListenerImpl<String> listener = new EventListenerImpl<>(true);
		return new QueueEventServiceImpl<>(listener, session);
	}
	
	private SequeueEventServiceImpl<String> getSequeueEventService() {
		EventListenerImpl<String> listener = new EventListenerImpl<>(true);
		return new SequeueEventServiceImpl<>(listener);
	}
}
