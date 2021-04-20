package com.qa.Exercises;

public class Motorbike extends Vehicle {
	private int displacement; // 125cc, 250cc etc
	private String engineType; // 2 stroke, 4 stroke etc.
	
	public Motorbike(int id, String name, 
			           int displacement, String engineType) {
		super(id, name);
		this.displacement = displacement;
		this.engineType = engineType;
	}
	
	public int getDisplacement() {
		return displacement;
	}
	
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	public String getEngineType() {
		return engineType;
	}
	
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
}
