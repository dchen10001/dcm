package com.nice.dcm.simulation.contact.input.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.simulation.contact.input.CTCallVolume;
import com.nice.dcm.simulation.contact.input.IntervalCallVolume;

public class CallVolumeMapper {
	private static Logger logger = LoggerFactory.getLogger(CallVolumeMapper.class);

	public List<IntervalVolumeImpl> map(List<CTCallVolume> callVolumes) {
		Map<Long, IntervalVolumeImpl> intervalMap = new HashMap<>();
		for (CTCallVolume ctCallVolume : callVolumes) {
			long id = ctCallVolume.getId();
			logger.debug("Processing CT Call Volume: id = {}", id);
			
			List<IntervalCallVolume> intervalCallVolumes = ctCallVolume.getIntervals();
			for (IntervalCallVolume intervalCallVolume : intervalCallVolumes) {
				long startTime = intervalCallVolume.getStartTime();
				intervalMap.computeIfAbsent(startTime, 
						k -> new IntervalVolumeImpl(startTime, intervalCallVolume.getDuration()))
				        .addCTVolume(id, intervalCallVolume.getCallVolume());
			}
		}
		
		return intervalMap.values().stream().sorted().toList();		
	}
}
