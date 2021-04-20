package com.qa.OOP;

public class Bird extends Animal implements FlyingCreature, HairyCreature {
	
	public void eat() {
		System.out.println("Peck peck nom nom");
	}
	
	public void speak() {
		System.out.println("TWEET TWEET");
	}
	
	public void fly() {
		System.out.println("Flap Flap WHEEeeeeee!");
	}
	
	public void preen() {
		System.out.println("Peck peck peck");
	}
}
