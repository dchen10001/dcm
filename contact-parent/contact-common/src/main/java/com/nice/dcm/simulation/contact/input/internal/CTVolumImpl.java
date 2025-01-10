package com.nice.dcm.simulation.contact.input.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class CTVolumImpl {
	private long id;
	private double callVolume;

	public CTVolumImpl(long id, double callVolume) {
		this.id = id;
		this.callVolume = callVolume;
	}
}
