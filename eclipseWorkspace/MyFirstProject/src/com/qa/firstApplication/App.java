package com.qa.firstApplication;
// STRINGS
public class App {
	public static String name = "Martin"; // Class scope
	
	public static void main(String[] args) {
		String returnedValue = imAConsultant(name);
		System.out.println(returnedValue);
	}
	
	public static String imAConsultant(String myName) {
		// function appends String param and returns sentence
		String sentence = "I'm a consultant called " + myName;
		return sentence;
	}
	
}
