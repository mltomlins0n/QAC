package com.qa.OOP;

import java.util.ArrayList;

public class Person {
	public String name;
	public int age;
	public static ArrayList<Person> people = new ArrayList<Person>();
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		// Add instance of Person to list as they are created
		people.add(this);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n"
				+ "Age: " + age;
	}
}
