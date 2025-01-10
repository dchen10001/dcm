package com.nice.dcm.simulation.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nice.dcm.simulation.contact.input.CTCallVolume;
import com.nice.dcm.simulation.contact.input.CTCallVolumeImpl;
import com.nice.dcm.simulation.contact.input.IntervalCallVolume;
import com.nice.dcm.simulation.contact.input.IntervalCallVolumeImpl;

public class CallVolumeGenerator {
	private Random random;
	private long daysInSecond = 86400;
	long duration = 900;
	public CallVolumeGenerator() {
		random = new Random();
	}
	
	public List<CTCallVolume> getCtCallVolumes(int ctCount, int days) {
		List<CTCallVolume> ctCallVolumes = new ArrayList<>();
		for (int i = 1; i <= ctCount; i++) {
			ctCallVolumes.add(generateCTCallVolume(i, days));
		}
		return ctCallVolumes;
	}

	public CTCallVolume generateCTCallVolume(long id, int days) {
		List<IntervalCallVolume> intervals = generateCallVolume(days);
		return new CTCallVolumeImpl(id, intervals);
	}
	
	public List<IntervalCallVolume> generateCallVolume(int days) {
		List<IntervalCallVolume> intervals = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			for(int j = 32; j < 68; j++) {
				long startTime = i * daysInSecond + j * duration;
				double callVolume = randomDouble(100.50, 0.50);
				intervals.add(new IntervalCallVolumeImpl(startTime, duration, callVolume));
			}
		}
		return intervals;
	}
	
	private double randomDouble(double max, double min) {
		return random.nextDouble() * (max - min) + min;
	}
}
