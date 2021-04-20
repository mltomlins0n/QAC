package com.qa.firstApplication;
// TRANSFER AND CONTROL
public class App7 {
	public static void main(String[] args) {
		transfer();
	}
	public static void transfer() {
		for (int i = 0; i <=10; i++) {
			if (i == 4) {
				continue; // Rest of the code is skipped, print doesn't run
			}
			else if (i == 7) {
				break;
			}
			else {
				System.out.println(i);
			}
		}
	}
}
