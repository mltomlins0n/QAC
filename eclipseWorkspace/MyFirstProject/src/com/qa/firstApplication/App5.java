package com.qa.firstApplication;
// LOOPS
public class App5 {
	public static void main(String[] args) {
		//forLoop();
		//whileLoop();
		//increment();
	}
	
	public static void forLoop() {
		for (int i = 0;i < 5; ++i) {
			System.out.println("I am line " + (i + 1));
		}
	}
	
	public static void whileLoop() {
		int line = 1;
	    while (line < 5) {
		    System.out.println("I am line " + line++);
	    }
	}
	
	public static void increment() {
		int x = 2;
		// Increments, but doesn't display as such on first call
		System.out.println("x is " + x++); // outputs 2, but x is 3
		// Increments and displays on first call
		System.out.println("x is " + ++x); // outputs 4
	}
	
}
