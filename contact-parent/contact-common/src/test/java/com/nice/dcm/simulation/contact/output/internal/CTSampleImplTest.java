package com.nice.dcm.simulation.contact.output.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.jupiter.api.Test;

class CTSampleImplTest {
	@Test
	void testCompareTo() {
		
		
		CTSampleImpl ctSampleImpl = new CTSampleImpl(1, 2);
		assertEquals(1, ctSampleImpl.getId());
		assertEquals(2, ctSampleImpl.getArrivalTime());
		
		CTSampleImpl ctSampleImpl2 = new CTSampleImpl(2, 2);
		assertEquals(2, ctSampleImpl2.getId());
		assertEquals(2, ctSampleImpl2.getArrivalTime());
		assertEquals(0, ctSampleImpl.compareTo(ctSampleImpl2));

		CTSampleImpl ctSampleImpl3 = new CTSampleImpl(3, 3);		
		assertEquals(-1, ctSampleImpl.compareTo(ctSampleImpl3));
		
		List<CTSampleImpl> ctSampleImpls = new ArrayList<>();
		ctSampleImpls.add(ctSampleImpl);
		ctSampleImpls.add(ctSampleImpl2);
		ctSampleImpls.add(ctSampleImpl3);
		
		Collections.sort(ctSampleImpls);
		assertEquals(ctSampleImpl, ctSampleImpls.get(0));
		assertEquals(ctSampleImpl2, ctSampleImpls.get(1));
		assertEquals(ctSampleImpl3, ctSampleImpls.get(2));
		
		Iterator<CTSampleImpl> cursor = List.of(ctSampleImpl, ctSampleImpl2, ctSampleImpl3).iterator();
		cursor.hasNext();
		cursor.hasNext();
		cursor.hasNext();
		cursor.hasNext();
		cursor.hasNext();
		
		assertEquals(ctSampleImpl, cursor.next());
		assertEquals(ctSampleImpl2, cursor.next());
		
		
	}
	
	@Test
	void testQueueTest() {
		Random random = new Random();
		long startTime = System.currentTimeMillis();
		List<CTSampleImpl> ctSampleImpls = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			CTSampleImpl ctSampleImpl = new CTSampleImpl(random.nextInt(10) + 1, random.nextInt(10) + 1);
			ctSampleImpls.add(ctSampleImpl);
		}
		ctSampleImpls.sort(null);
		Collections.sort(ctSampleImpls);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to sort: " + (endTime - startTime) + " ms");
		
		
		startTime = System.currentTimeMillis();
		
		PriorityQueue<CTSampleImpl> priorityQueue = new PriorityQueue<>();
		
		for (int i = 0; i < 10000; i++) {
			CTSampleImpl ctSampleImpl = new CTSampleImpl(random.nextInt(10) + 1, random.nextInt(10) + 1);
			priorityQueue.add(ctSampleImpl);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to add to queue: " + (endTime - startTime) + " ms");
	}
}
