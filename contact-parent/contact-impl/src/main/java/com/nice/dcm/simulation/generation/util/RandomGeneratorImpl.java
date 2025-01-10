package com.nice.dcm.simulation.generation.util;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.statistics.distribution.ContinuousDistribution.Sampler;
import org.apache.commons.statistics.distribution.NormalDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.NonNull;

public class RandomGeneratorImpl implements SampleGenerator {
	private static final Logger logger = LoggerFactory.getLogger(RandomGeneratorImpl.class);
	
	private static final int DEFAULT_SD = 1;

	private double mean = -1;
	private double sd = DEFAULT_SD;
	private Sampler sampler;
	
	private final UniformRandomProvider uniformRandomProvider;

	public RandomGeneratorImpl(@NonNull UniformRandomProvider uniformRandomProvider) {
		this.uniformRandomProvider = uniformRandomProvider;
	}
	
	@Override
	public long[] sample(int callVolume, long duration) {
		if (callVolume <= 0) {
			return new long[0];
		}
		
		double arravingRate = (double)duration / (double)callVolume;
		
		logger.debug("Arraving rate: {}/{} = {}", duration, callVolume, arravingRate);
		
		long[] sequence =  new long[callVolume];
		Sampler s = getSampler((long)arravingRate);
		for (int i = 0; i < callVolume; i++) {
			long start = (long)arravingRate * i;
			long end = start + (long)arravingRate;
			long arrival = Math.round(arravingRate * i + 0.5 * arravingRate);
			double sample = s.sample();
			sequence[i] = Math.round(arrival + sample);
			sequence[i] = limitValue(sequence[i], start, end);
		}
        return sequence;
	}
	
	protected long limitValue(long arrival, long startTime, long endTime) {
		if (arrival < startTime) {
			return startTime;
		} else if (arrival > endTime) {
			return endTime;
		}
		return arrival;
	}
	
	private Sampler getSampler(double arravingRate) {
		if (sampler == null) {
			double localMean = getMean(arravingRate);
			logger.debug("mean is {}.", localMean);
			NormalDistribution exp = NormalDistribution.of(localMean, this.getSd());
			sampler = exp.createSampler(uniformRandomProvider);
		}
		return sampler;
	}
	
	protected double getMean(double arravingRate) {
		if (this.mean < 0) {
			logger.debug("Mean is not set. Using call volume as mean");
			return 0.25 * arravingRate;
		}
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getSd() {
		return sd;
	}

	public void setSd(double sd) {
		this.sd = sd;
	}
}
