package com.qa.firstApplication;
// RECURSION
public class App6 {
	public static void main(String[] args) {
		System.out.println(handCount(6));
	}
	
	public static int handCount(int numPeople) {
		// Base case
		if (numPeople == 0) {
			return 0;
		}
		else {
			return handCount(numPeople -1) + 2;
		}
	}
}
