package com.nice.dcm.simulation.contact.input;

import java.util.List;

public interface CTCallVolume {
	long getId();
	List<IntervalCallVolume> getIntervals();
}
