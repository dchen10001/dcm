package com.nice.dcm.simulation.generation;

public enum SamplingType implements SampleConverter {
	UPPER_BOUND() {
		@Override
        public int convert(double value) {
            return (int)Math.ceil(value);
        }
    }, 
	
	ROUND() {
		@Override
		public int convert(double value) {
			return (int) Math.round(value);
		}
	},
	
	LOWER_BOUND() {
        @Override
        public int convert(double value) {
            return (int)value;
        }
    };
}
