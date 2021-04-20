package com.qa.Exercises;

public class Iteration {
	public static void main(String[] args) {
		//flowchartB();
		flowchartC();
	}
	
	public static void flowchartB() {
		int a = 100;
		while (a < 200) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void flowchartC() {
		int a = 100;
		while(a <= 200) {
			if (a % 2 == 0) {
				System.out.print("-");
			}
			else {
				System.out.print("*");
			}
			a++;
		}
	}
}
