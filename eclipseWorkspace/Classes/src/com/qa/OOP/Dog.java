package com.qa.OOP;

public class Dog extends Animal {
	public String name;
	public boolean hasBall = false;
	public String colour;
	
	public Dog(String name, String colour) {
		this.name = name;
		this.colour = colour;
	}
	
	public void eat() {
		System.out.println("Chomp chomp lick");
	}
	
	public void speak() {
		System.out.println("BORK");
	}
}
