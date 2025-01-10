package com.nice.dcm.simulation.generation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.contact.input.CTCallVolume;
import com.nice.dcm.simulation.contact.input.CTCallVolumeImpl;
import com.nice.dcm.simulation.contact.input.IntervalCallVolume;
import com.nice.dcm.simulation.contact.input.IntervalCallVolumeImpl;
import com.nice.dcm.simulation.contact.output.internal.CTSampleImpl;

class SampleGenerationServiceImplTest {
	
	@Test
	void testGeneratorOneCt() {
		List<CTCallVolume> ctCallVolumes = List.of(generateCTCallVolume(10));
		SamplingType samplingType = SamplingType.UPPER_BOUND;
		ArrivingType generatorType = ArrivingType.SEQUENCE;
		long totalContact = getTotalContact(ctCallVolumes, samplingType);
		assertEquals(60, totalContact);
		
		EventService<CTSampleImpl> sampleGeneratorService = new SampleGenerationServiceImpl(ctCallVolumes, generatorType, samplingType);
		for(int k = 0; k < 10; k++) {
			int i = 0;
			while(sampleGeneratorService.hasNext()) {
				long currentTime = sampleGeneratorService.nextEventTime();
				long expected = 75 + i * 150;
				assertEquals(expected, currentTime);
				List<CTSampleImpl> samples = sampleGeneratorService.nextEvents(currentTime);
				assertEquals(1, samples.size());
				i++;
			}
			assertEquals(60, i);
			sampleGeneratorService.reset();
		}
	}
	
	@Test
	void testGenerator3CT() {
		List<CTCallVolume> ctCallVolumes = List.of(generateCTCallVolume(10), generateCTCallVolume(20), generateCTCallVolume(30));
		SamplingType samplingType = SamplingType.UPPER_BOUND;
		ArrivingType generatorType = ArrivingType.SEQUENCE;
		long totalContact = getTotalContact(ctCallVolumes, samplingType);
		assertEquals(60 * 3, totalContact);
		
		EventService<CTSampleImpl> sampleGeneratorService = new SampleGenerationServiceImpl(ctCallVolumes, generatorType, samplingType);
		
		for(int k = 0; k < 10; k++) {
			int i = 0;
			while(sampleGeneratorService.hasNext()) {
				long currentTime = sampleGeneratorService.nextEventTime();
				long expected = 75 + i * 150;
				assertEquals(expected, currentTime);
				List<CTSampleImpl> samples = sampleGeneratorService.nextEvents(currentTime);
				assertEquals(3, samples.size());
				Set<Long> ids = new HashSet<>();
				for(CTSampleImpl s : samples) {
	                ids.add(s.getId());
	            }
				assertEquals(3, ids.size());
				assertTrue(ids.contains(10L));
				assertTrue(ids.contains(20L));
				assertTrue(ids.contains(30L));
				i++;
			}
			assertEquals(60, i);
			sampleGeneratorService.reset();
		}
	}
	
	@Test
	void testPerformanceSequence() {
		List<CTCallVolume> ctCallVolumes = getCTCallVolumes(500, 30);
		SamplingType samplingType = SamplingType.UPPER_BOUND;
		ArrivingType generatorType = ArrivingType.SEQUENCE;
		long totalContact = getTotalContact(ctCallVolumes, samplingType);
		
		long startTime = System.currentTimeMillis();
		EventService<CTSampleImpl> sampleGeneratorService = new SampleGenerationServiceImpl(ctCallVolumes, generatorType, samplingType);
		int i = 0;
		while(sampleGeneratorService.hasNext()) {
			long currentTime = sampleGeneratorService.nextEventTime();
			List<CTSampleImpl> samples = sampleGeneratorService.nextEvents(currentTime);
			i += samples.size();
		}
		long endTime = System.currentTimeMillis();
		assertEquals(totalContact, i);
		System.out.println("totalContact: " + totalContact);
		System.out.println("Time: " + (endTime - startTime));
	}
	
	@Test
	void testPerformanceExponential() {
		List<CTCallVolume> ctCallVolumes = getCTCallVolumes(500, 30);
		SamplingType samplingType = SamplingType.UPPER_BOUND;
		ArrivingType generatorType = ArrivingType.EXPONENTIAL;
		long totalContact = getTotalContact(ctCallVolumes, samplingType);
		
		long startTime = System.currentTimeMillis();
		EventService<CTSampleImpl> sampleGeneratorService = new SampleGenerationServiceImpl(ctCallVolumes, generatorType, samplingType);
		int i = 0;
		while(sampleGeneratorService.hasNext()) {
			long currentTime = sampleGeneratorService.nextEventTime();
			List<CTSampleImpl> samples = sampleGeneratorService.nextEvents(currentTime);
            i += samples.size();
		}
		long endTime = System.currentTimeMillis();
		assertEquals(totalContact, i);
		System.out.println("totalContact: " + totalContact);
		System.out.println("Time: " + (endTime - startTime));
	}
	
	@Test
	void testPerformanceRandom() {
		List<CTCallVolume> ctCallVolumes = getCTCallVolumes(500, 30);
		SamplingType samplingType = SamplingType.UPPER_BOUND;
		ArrivingType generatorType = ArrivingType.RANDOM;
		long totalContact = getTotalContact(ctCallVolumes, samplingType);
		
		long startTime = System.currentTimeMillis();
		EventService<CTSampleImpl> sampleGeneratorService = new SampleGenerationServiceImpl(ctCallVolumes, generatorType, samplingType);
		int i = 0;
		while(sampleGeneratorService.hasNext()) {
			long currentTime = sampleGeneratorService.nextEventTime();
			List<CTSampleImpl> samples = sampleGeneratorService.nextEvents(currentTime);
			i += samples.size();
		}
		long endTime = System.currentTimeMillis();
		assertEquals(totalContact, i);
		System.out.println("totalContact: " + totalContact);
		System.out.println("Time: " + (endTime - startTime));
	}
	
	private List<CTCallVolume> getCTCallVolumes(int ctCount, int days) {
		CallVolumeGenerator  callVolumeGenerator = new CallVolumeGenerator();
		return callVolumeGenerator.getCtCallVolumes(ctCount, days);
	}
	
	private long getTotalContact(List<CTCallVolume> ctCallVolumes, SamplingType samplingType) {
		long totalContact = 0;
		for (CTCallVolume ctCallVolume : ctCallVolumes) {
			for(IntervalCallVolume interval :  ctCallVolume.getIntervals()) {
				totalContact += samplingType.convert(interval.getCallVolume());
			}
		}
		return totalContact;
	}
	
	public CTCallVolume generateCTCallVolume(long id) {
		List<IntervalCallVolume> intervals = generateCallVolume();
		return new CTCallVolumeImpl(id, intervals);
	}
	
	public List<IntervalCallVolume> generateCallVolume() {
		List<IntervalCallVolume> intervals = new ArrayList<>();
		long duration = 900;
		for (int i = 0; i < 10; i++) {
			long startTime = i * duration;
			double callVolume = 5.5;
			intervals.add(new IntervalCallVolumeImpl(startTime, duration, callVolume));
		}
		return intervals;
	}
}
