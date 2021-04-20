package com.qa.OOP;

public class Penguin extends Animal {
	public String fluffiness;
	
	public Penguin(String fluffiness) {
		this.fluffiness = fluffiness;
	}
	
	public void eat() {
		System.out.println("Gulg gulp");
	}

	public void speak() {
		System.out.println("NOOT NOOT");
	}
	public void swim() {
		System.out.println("Splish Splash");
	}
}