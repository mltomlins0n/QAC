package com.qa.demoproject;

public class App {
	public static void main(String[] args) {
		Game semi_finals = new Game(0, 90, "football");
		Game final_table = new Game(30000, "poker");
		Game the_open = new Tennis(0, 0, "Tennis");
		
		the_open.addToScore(1);
		System.out.println(the_open.getScore());
		
	}
}
