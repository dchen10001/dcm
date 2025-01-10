package com.nice.dcm.simulation.contact.input;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CTCallVolumeImpl implements CTCallVolume {
	private long id;
	private List<IntervalCallVolume> intervals;
	
	public CTCallVolumeImpl(long id, List<IntervalCallVolume> intervals) {
		this.id = id;
		this.intervals = intervals;
	}
}
