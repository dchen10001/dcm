package com.nice.dcm.simulation.contact.output.internal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class CTSampleImpl implements Comparable<CTSampleImpl> {
	private final long id;
    private final long arrivalTime;
    
	@Override
	public int compareTo(CTSampleImpl o) {
		if (arrivalTime < o.arrivalTime)
			return -1;
		else if (arrivalTime > o.arrivalTime)
			return 1;
		return 0;
	}
}
