package com.nice.dcm.simlation.core.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class TimeEventTest {
	@Test
	void testGetId() {
		TimeEvent.reSetId();
		
		List<TimeEvent<?>> list = new ArrayList<>();
		PriorityQueue<TimeEvent<?>> queue = new PriorityQueue<>();
		
		int i = 0;
		TimeEventImpl<String> stringEvent1 = new TimeEventImpl<>(10, "stringEvent1");
		assertEquals(i++, stringEvent1.getEventId());
		list.add(stringEvent1);
		queue.add(stringEvent1);
		
		TimeEventImpl<String> stringEvent2 = new TimeEventImpl<>(5, "stringEvent2");
		assertEquals(i++, stringEvent2.getEventId());
		list.add(stringEvent2);
		queue.add(stringEvent2);
		
		TimeEventImpl<String> stringEvent3 = new TimeEventImpl<>(13, "stringEvent3");
		assertEquals(i++, stringEvent3.getEventId());
		list.add(stringEvent3);
		queue.add(stringEvent3);
		
		TimeEventImpl<Long> longEvent1 = new TimeEventImpl<>(3, 1l);
		assertEquals(i++, longEvent1.getEventId());
		list.add(longEvent1);
		queue.add(longEvent1);
		
		TimeEventImpl<Long> longEvent2 = new TimeEventImpl<>(7, 2l);
		assertEquals(i++, longEvent2.getEventId());
		list.add(longEvent2);
		queue.add(longEvent2);
		
		TimeEventImpl<Long> longEvent3 = new TimeEventImpl<>(1, 3l);
		assertEquals(i++, longEvent3.getEventId());
		list.add(longEvent3);
		queue.add(longEvent3);
		
		list.sort(null);
		TimeEvent<?> event = list.get(0);
		for (i = 1; i < list.size(); i++) {
			TimeEvent<?> next = list.get(i);
			assertEquals(event.getEventTime() <= next.getEventTime(), true);
			event = next;
		}
		
		i = 0;
		while (!queue.isEmpty()) {
			assertSame(list.get(i++), queue.poll());
		}
	}
}
