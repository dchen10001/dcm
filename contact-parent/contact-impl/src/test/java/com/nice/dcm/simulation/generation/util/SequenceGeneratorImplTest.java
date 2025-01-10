package com.nice.dcm.simulation.generation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.generation.util.SequenceGeneratorImpl;

class SequenceGeneratorImplTest {
	
	@Test
	void testSample() {
		SequenceGeneratorImpl generator = new SequenceGeneratorImpl();
		long[] sequence = generator.sample(10, 900);
		long duration = 900 / 10;
		
		assertEquals(10, sequence.length);
		assertTrue(sequence[0] >= 0);
		for (int i = 1; i < sequence.length; i++) {
			assertTrue(sequence[i] >= sequence[i - 1]);
			assertEquals(sequence[i] - sequence[i - 1] , duration);
			assertTrue(sequence[i] <= 900);
		}
		
		sequence = generator.sample(0, 900);
		assertEquals(0, sequence.length);
	}	
}
