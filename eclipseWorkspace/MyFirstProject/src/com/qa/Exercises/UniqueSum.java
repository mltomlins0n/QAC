package com.qa.Exercises;

public class UniqueSum {
	public static void main(String[] args) {
		System.out.println(sum(2,1,2));
	}
	
	public static int sum(int a, int b, int c) {
		if (a == b && b == c) {
			return 0;
		}
		else if (a == b) {
			return c;
		}
		else if (b == c) {
			return a;
		}
		else if (a == c) {
			return b;
		}
		return a + b + c;
	}
}
