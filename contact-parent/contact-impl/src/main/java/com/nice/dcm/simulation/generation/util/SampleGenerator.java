package com.nice.dcm.simulation.generation.util;

import com.nice.dcm.simulation.generation.ArrivingType;
import com.nice.dcm.simulation.generation.random.UniformRandomProviderFactory;

import lombok.NonNull;

public interface SampleGenerator {
	long[] sample(int callVolume, long duration);
	
	static SampleGenerator create(@NonNull ArrivingType generatorType, long seed) {
		switch(generatorType) {
		case EXPONENTIAL:
			return new ExponentialGeneratorImpl(UniformRandomProviderFactory.createKiss(seed));
		case RANDOM:
			return new RandomGeneratorImpl(UniformRandomProviderFactory.createKiss(seed));
		default:
			return new SequenceGeneratorImpl();
		}
	}
}
