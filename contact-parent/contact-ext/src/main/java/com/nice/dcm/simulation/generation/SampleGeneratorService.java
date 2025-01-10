package com.nice.dcm.simulation.generation;

import org.apache.commons.statistics.distribution.PoissonDistribution;

public interface SampleGeneratorService {

	default double getPoissonPossibility(double mean, int volume) {
		if(volume < 0) {
			throw new IllegalArgumentException("volume is less than 0.");
		}
		PoissonDistribution generator = getPoissonDistribution(mean);
		return generator.probability(volume);
	}
	
	private PoissonDistribution getPoissonDistribution(double mean) {
		if(mean <= 0) {
			throw new IllegalArgumentException("mean must be great than 0.");
		}
		return PoissonDistribution.of(mean);
	}
}
