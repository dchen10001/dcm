package com.nice.dcm.simulation.generation.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.statistics.distribution.ContinuousDistribution.Sampler;
import org.apache.commons.statistics.distribution.ExponentialDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.NonNull;

public class ExponentialGeneratorImpl implements SampleGenerator {
	private static final Logger logger = LoggerFactory.getLogger(ExponentialGeneratorImpl.class);
	private final UniformRandomProvider uniformRandomProvider;

	public ExponentialGeneratorImpl(@NonNull UniformRandomProvider uniformRandomProvider) {
		this.uniformRandomProvider = uniformRandomProvider;
	}
	
	@Override
	public long[] sample(int callVolume, long duration) {
		if (callVolume <= 0) {
			return new long[0];
		}
		
		double arrivalRate = (double)duration/callVolume; // call per seconds
		
		logger.debug("Arraving rate: {}/{} = {}", duration, callVolume, arrivalRate);
		ExponentialDistribution exponentialDistribution = ExponentialDistribution.of(arrivalRate);
		
		Sampler sampler = exponentialDistribution.createSampler(uniformRandomProvider);
		
		long[] sequence =  new long[callVolume];
		double arriving = round(sampler.sample(), 1);
    	sequence[0] = Math.round(arriving);
		for (int i = 1; i < callVolume; i++) {
			arriving = round(sampler.sample(), 1);
        	sequence[i] = Math.round(arriving) + sequence[i-1];
		}
		
		if(sequence[callVolume-1] > duration) {
			double rate = (double)(duration - 1) / (double)sequence[callVolume-1];
			for (int i = 0; i < callVolume; i++) {
				sequence[i] = Math.round(sequence[i] * rate);
			}
		}
        return sequence;
	}
	
	
	protected double getMean(double arrivalRate) {
		return 1 / arrivalRate;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
