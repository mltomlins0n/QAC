package com.qa.Collections;

import java.util.ArrayList;

public class Array {
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public void createArray1() {
		int[] numbers = new int[100];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
			System.out.println(numbers[i]);
		}
	}
	
	public void createArray2() {
		
		for (int i = 100; i <= 999; i++) {
			numbers.add(i);
		}
		
		for (int num : numbers) {
			System.out.println(num);
		}
	}
	
	public void multiplyListItems() {
		
		for (int num : numbers) {
			num *= 10;
			System.out.println(num);
		}
	}
}
