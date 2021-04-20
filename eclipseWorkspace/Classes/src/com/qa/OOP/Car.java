package com.qa.OOP;

public class Car extends Vehicle {
	private int wheels;
	
	public Car(int id, String name, int wheels) {
		super(id, name);
		this.wheels = wheels;
	}
	
	public String getWheels() {
		return "Wheels: " + wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
}
