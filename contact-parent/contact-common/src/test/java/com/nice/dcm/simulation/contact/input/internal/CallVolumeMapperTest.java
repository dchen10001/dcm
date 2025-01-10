package com.nice.dcm.simulation.contact.input.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.contact.input.CTCallVolume;
import com.nice.dcm.simulation.contact.input.CTCallVolumeImpl;
import com.nice.dcm.simulation.contact.input.IntervalCallVolume;
import com.nice.dcm.simulation.contact.input.IntervalCallVolumeImpl;

class CallVolumeMapperTest {
	@Test
	void testMap() {
		List<CTCallVolume> ctCallVolumes = new ArrayList<>();
		long duration = 900;
		ctCallVolumes.add(getCTCallVolume(1, 0, duration, 10));
		ctCallVolumes.add(getCTCallVolume(2, 2, duration, 10));
		ctCallVolumes.add(getCTCallVolume(3, 4, duration, 10));
		
		CallVolumeMapper map = new CallVolumeMapper();
		List<IntervalVolumeImpl> intervalVolumes = map.map(ctCallVolumes);
		assertEquals(14, intervalVolumes.size());
		
		for (int i = 0; i < intervalVolumes.size(); i++) {
			IntervalVolumeImpl intervalVolume = intervalVolumes.get(i);
			assertEquals(i * duration, intervalVolume.getStartTime());
			assertEquals(duration, intervalVolume.getDuration());
			if (i < 2) {
				assertEquals(1, intervalVolume.getCtVolumes().size());
			} else if (i >= 2 && i < 4) {
				assertEquals(2, intervalVolume.getCtVolumes().size());
			} else if (i >= 4 && i < 10) {
				assertEquals(3, intervalVolume.getCtVolumes().size());
			} else if (i >= 10 && i < 12) {
				assertEquals(2, intervalVolume.getCtVolumes().size());
			} else if (i >= 12) {
				assertEquals(1, intervalVolume.getCtVolumes().size());
			}
		}
	}
	
	private CTCallVolume getCTCallVolume(long id, long start, long duration, int numIntervals) {
		return new CTCallVolumeImpl(id, getIntervalCallVolumes(start, duration, numIntervals));
	}
	
	private List<IntervalCallVolume> getIntervalCallVolumes(long startInverval, long duration, int numIntervals) {
		List<IntervalCallVolume> intervalCallVolumes = new ArrayList<>();
		for (int i = 0; i < numIntervals; i++) {
            IntervalCallVolumeImpl intervalCallVolume = new IntervalCallVolumeImpl((startInverval + i) * duration, duration, 1.0 + i * 0.1);
            intervalCallVolumes.add(intervalCallVolume);
        }
		return intervalCallVolumes;
	}
}
