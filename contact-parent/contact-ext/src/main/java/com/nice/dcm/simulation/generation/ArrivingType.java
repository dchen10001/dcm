package com.nice.dcm.simulation.generation;

public enum ArrivingType {
	RANDOM("Random", true), SEQUENCE("Sequence", false), EXPONENTIAL("Exponential", true);
	
	private String name;

	private boolean random;
	
	ArrivingType(String name, boolean random) {
		this.name = name;
		this.random = random;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isRandom() {
		return random;
	}
	
	public static ArrivingType fromName(String name) {
		for (ArrivingType type : values()) {
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}
		return null;
	}
}
