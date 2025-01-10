package com.nice.dcm.simulation.contact.output;

public interface IntervalTimeSeries {
	double getCallVolume();
	int getSampleSize();
	double getPosibliity();
	long[] getSampleArrivals();
}
