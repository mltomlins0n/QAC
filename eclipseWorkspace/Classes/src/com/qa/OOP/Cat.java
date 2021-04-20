package com.qa.OOP;

public class Cat extends Animal {
	public String name;
	public String fur;
	public int age;
	public int lives = 9;
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Cat(int age) {
		this.age = age;
	}
	
	public void eat() {
		System.out.println("Nom =(^.^)=");
	}
	
	public void speak() {
		System.out.println("MEOW MEOW");
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: " + name + " Age: " + age
				+ " Fur: " + fur + " Lives: " + lives;
	}
}
