package com.qa.OOP;

public class AnotherCat {
	// final variables cannot and should not be changed
	public final int lives = 9;
	public final String name = "Alvina";
	
	public static void main(String[] args) {
		/*
		AnotherCat salem = new AnotherCat();
		// variables are final, cannot be re-assigned
		salem.lives = 900000;
		salem.name = "Alvina";
		*/
		/*
		AnotherCat cat = new AnotherCat();
		YetAnotherCat cat2 = new YetAnotherCat();
		
		cat.eat();
		cat2.eat(); // Cannot override AnotherCat's final method
		*/
	}
	
	public void speak() {
		System.out.println("MEOW MEOW");
	}
	// Cannot be overriden
	public final void eat(){
		System.out.println("NOM");
	}
}
