package com.nice.dcm.simulation.contact.input;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IntervalCallVolumeImpl implements IntervalCallVolume {
	private long startTime;
	private long duration;
	private double callVolume;
	
	public IntervalCallVolumeImpl(long startTime, long duration, double callVolume) {
		this.startTime = startTime;
		this.duration = duration;
		this.callVolume = callVolume;
	}
}
