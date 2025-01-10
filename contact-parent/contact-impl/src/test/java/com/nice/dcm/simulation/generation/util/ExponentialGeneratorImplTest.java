package com.nice.dcm.simulation.generation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.generation.util.ExponentialGeneratorImpl;

class ExponentialGeneratorImplTest {
	UniformRandomProvider rng = RandomSource.KISS.create(123L);
	
	@Test
	void testSample() {
		ExponentialGeneratorImpl generator = new ExponentialGeneratorImpl(rng);
		for (int i = 0; i < 100; i++) {
			long[] sequence = generator.sample(10, 900);
			assertEquals(10, sequence.length);
			assertTrue(sequence[0] >= 0);
			for (int j = 1; j < sequence.length; j++) {
				assertTrue(sequence[j] >= sequence[j-1]);
				assertTrue(sequence[j] < 900);
			}
		}
		assertEquals(0, generator.sample(0, 900).length);
	}
}
