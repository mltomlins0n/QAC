package com.qa.Exercises;

public class Car extends Vehicle {
	private int wheels;
	private int numOfDoors;
	private String driveTrain; // AWD, FWD, RWD
	
	public Car(int id, String name, int wheels, 
			     int numOfDoors, String driveTrain) {
		super(id, name);
		this.wheels = wheels;
		this.numOfDoors = numOfDoors;
		this.driveTrain = driveTrain;
	}
	
	public String getWheels() {
		return "Wheels: " + wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public String getDoors() {
		return "Number of doors: " + numOfDoors;
	}
	
	public void setnumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	
	public String getDriveTrain() {
		return driveTrain;
	}
	
	public void setDriveTrain(String driveTrain) {
		this.driveTrain = driveTrain;
	}
	
	
	public String toString() {
		String output = "";
		output += super.toString();
		output += " Wheels: " + wheels;
		output += " Doors: " + numOfDoors;
		output += " Drivetrain: " + driveTrain;
		return output;
	}
}
