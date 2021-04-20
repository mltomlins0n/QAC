package com.qa.OOP;

public class Vehicle {
	private int id;
	private String name;
	
	public Vehicle(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return "Vehicle ID: " + id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return "Vehicle Name: " + name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
