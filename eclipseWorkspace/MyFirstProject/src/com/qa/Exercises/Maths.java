package com.qa.Exercises;

// MATHS METHODS
public class Maths {
	public static void main(String[] args) {
	Maths maths = new Maths();
	
	System.out.println(maths.add(40,2));
	System.out.println(maths.multiply(6,7));
	System.out.println(maths.subtract(50,8));
	System.out.println(maths.divide(84,2));
	}
		
	public int add(int num1, int num2) {
		return num1 + num2;
		}
		
	public int multiply(int num1, int num2) {
		return num1 * num2;
		}
		
	public int subtract(int num1, int num2) {
		return num1 - num2;
		}
		
	public double divide(int num1, int num2) {
		if (num1 > num2) {
			return num1 / num2;
			}
		else {
			return num2 / num1;
			}
		}
}
