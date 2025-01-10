package com.nice.dcm.simulation.generation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.generation.util.RandomGeneratorImpl;

class RandomGeneratorImplTest {
	UniformRandomProvider rng = RandomSource.KISS.create(123L);
	
	@Test
	void testSample() {
		RandomGeneratorImpl generator = new RandomGeneratorImpl(rng);
		long[] sequence = generator.sample(10, 900);
		assertEquals(10, sequence.length);
		assertTrue(sequence[0] >= 0);
		for (int i = 1; i < sequence.length; i++) {
			assertTrue(sequence[i] >= sequence[i-1]);
			assertTrue(sequence[i] <= 900);
		}
		
		sequence = generator.sample(0, 900);
		assertEquals(0, sequence.length);
	}
}
