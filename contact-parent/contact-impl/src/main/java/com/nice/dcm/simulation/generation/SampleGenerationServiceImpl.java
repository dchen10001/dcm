package com.nice.dcm.simulation.generation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.simulation.contact.input.CTCallVolume;
import com.nice.dcm.simulation.contact.input.internal.CTVolumImpl;
import com.nice.dcm.simulation.contact.input.internal.CallVolumeMapper;
import com.nice.dcm.simulation.contact.input.internal.IntervalVolumeImpl;
import com.nice.dcm.simulation.contact.output.internal.CTSampleImpl;
import com.nice.dcm.simulation.generation.util.SampleGenerator;

import lombok.NonNull;

public class SampleGenerationServiceImpl implements SampleGeneratorService, EventService<CTSampleImpl> {
	private static final Logger logger = LoggerFactory.getLogger(SampleGenerationServiceImpl.class);

	private static final long DEFAULT_SEED = 123L;
	
	private final SamplingType samplingType;
	
	private SampleGenerator sampleGenerator;
	
	private final List<IntervalVolumeImpl> intervalVolumes;
	
	//working variables
	private Iterator<IntervalVolumeImpl> cursor;
	
	private PriorityQueue<CTSampleImpl> sampleQueue = new PriorityQueue<>();
	
	private CTSampleImpl nextSample;
	
	private long count = 0;
	
	public SampleGenerationServiceImpl(List<CTCallVolume> ctCallVolumes, ArrivingType generatorType,
			SamplingType samplingType) {
		this(ctCallVolumes, generatorType, samplingType, DEFAULT_SEED);
	}

	public SampleGenerationServiceImpl(@NonNull List<CTCallVolume> ctCallVolumes, @NonNull ArrivingType generatorType,
			@NonNull SamplingType samplingType, long seed) {

		this.samplingType = samplingType;
		CallVolumeMapper callVolumeMapper = new CallVolumeMapper();
		this.intervalVolumes = callVolumeMapper.map(ctCallVolumes);
		this.sampleGenerator = SampleGenerator.create(generatorType, seed);
		reset();
	}

	@Override
	public void reset() {
		this.sampleQueue.clear();
		this.count = 0;
		this.nextSample = null;
		this.cursor = intervalVolumes.iterator();
		if(cursor.hasNext()) {
			nextSample = generateNext();
		}
	}

	@Override
	public boolean hasNext() {
		return nextSample != null;
	}
	
	@Override
	public long nextEventTime() {
		if (!hasNext()) {
			throw new IllegalStateException("No more samples to generate");
		}
		return nextSample.getArrivalTime();
	}
	
	@Override
	public List<CTSampleImpl> nextEvents(long currentTime) {
		if (!hasNext() || currentTime < nextSample.getArrivalTime()) {
			return List.of();
		}
		
		if (currentTime > nextSample.getArrivalTime()) {
			throw new IllegalArgumentException("Current time is greater than next sample arrival time");
		}
		
		List<CTSampleImpl> samples = new ArrayList<>();
		samples.add(nextSample);
		
		nextSample = null;
		while (!this.sampleQueue.isEmpty()) {
			nextSample = this.sampleQueue.poll();
			if (nextSample.getArrivalTime() != currentTime) {
				break;
			}
			samples.add(nextSample);
			nextSample = null;
		} 
		
		if (nextSample == null && this.sampleQueue.isEmpty()) {
			nextSample = generateNext();
		} 
		count += samples.size();
		return samples;
	}
	
	public long getCount() {
		return count;
	}
	
	private CTSampleImpl generateNext() {
		if (!this.cursor.hasNext()) {
			logger.debug("No more interval volumes to process");
			return null;
		}
		
		IntervalVolumeImpl intervalVolume = this.cursor.next();
		long duration = intervalVolume.getDuration();
		long startTime = intervalVolume.getStartTime();

		for(CTVolumImpl ctVolumImpl : intervalVolume.getCtVolumes()) {
			long id = ctVolumImpl.getId();
			double callVolume = ctVolumImpl.getCallVolume();
			logger.debug("Generating calls for CT Volume: id = {}, callVolume = {}", id, callVolume);
			int volume = samplingType.convert(callVolume);		
			long[] arrivings = sampleGenerator.sample(volume, duration);
			for (long arriving : arrivings) {
				sampleQueue.add(new CTSampleImpl(id, startTime + arriving));
			}
		}
		return this.sampleQueue.poll();
	}
}
