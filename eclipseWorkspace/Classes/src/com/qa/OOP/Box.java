package com.qa.OOP;

public class Box {
	public static String colour;
	public static String item;
	
	@Override
	public String toString() {
		return "Box colour: " + colour
				+ "\n" + "Item in box: " + item;
	}
}
