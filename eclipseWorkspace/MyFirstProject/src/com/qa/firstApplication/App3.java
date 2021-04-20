package com.qa.firstApplication;
// BLACKJACK
public class App3 {
	public static void main(String[] args) {
		System.out.println(blackjack(4,21));
	}
	
	public static int blackjack(int num1, int num2) {
		// check for valid numbers
		if (num1 < 4 || num2 < 4) {
			System.out.println("Invalid numbers, try again");
			return -1;
		}
		else if (num1 > 21 || num2 > 21) {
			if (num1 < num2) {
				return num1;
			}
		}
		// Choose correct answer
		if (num1 > num2) {
			return num1;
		}
		else {
			return num2;
		}
	}
}
