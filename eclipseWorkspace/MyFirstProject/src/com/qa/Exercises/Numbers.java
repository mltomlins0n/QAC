package com.qa.Exercises;

public class Numbers {
	public static void main(String[] args) {
		//addDigits(9876543);
		System.out.println(numToString(1));
	}
	
	public static void addDigits(int num) {
		int sum = 0;
		
		while (num > 0) {
			sum += num % 10; // gets the last digit in num and adds to sum
			num /= 10; // gives the next "last" digit
		}
		System.out.println("The sum of the digits in the number is: " + sum);
	}
	
	public static String numToString(int num){
		return String.valueOf(num);
	}
}
