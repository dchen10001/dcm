package com.nice.dcm.simulation.generation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceGeneratorImpl implements SampleGenerator {
	private static final Logger logger = LoggerFactory.getLogger(SequenceGeneratorImpl.class);

	@Override
	public long[] sample(int callVolume, long duration) {
		if (callVolume <= 0) {
			return new long[0];
		}
		
		double arravingRate = (double)duration / callVolume;
		logger.debug("Arraving rate: {}/{} = {}", duration, callVolume, arravingRate);
		
		long[] sequence =  new long[callVolume];
		for (int i = 0; i < callVolume; i++) {
			sequence[i] = Math.round(arravingRate * i + 0.5 * arravingRate);
		}
		return sequence;
	}
}
