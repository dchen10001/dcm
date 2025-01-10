package com.nice.dcm.simulation.contact.input.internal;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class IntervalVolumeImpl implements Comparable<IntervalVolumeImpl> {
	private long startTime;
	private long duration;
	
	private List<CTVolumImpl> ctVolumes;
	
	public IntervalVolumeImpl(long startTime, long duration) {
		this.startTime = startTime;
		this.duration = duration;
		this.ctVolumes = new ArrayList<>();
	}
	
	public void addCTVolume(CTVolumImpl volume) {
		this.ctVolumes.add(volume);
	}
	
	public void addCTVolume(long id, double callVolume) {
		this.ctVolumes.add(new CTVolumImpl(id, callVolume));
	}
	
	@Override
	public int compareTo(IntervalVolumeImpl o) {
		if (this.startTime < o.startTime) {
			return -1;
		} else if (this.startTime > o.startTime) {
			return 1;
		}
		return 0;
	}
}
