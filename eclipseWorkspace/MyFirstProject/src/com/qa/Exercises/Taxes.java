package com.qa.Exercises;

public class Taxes {
	public static float salary = 15000;
	public static int taxPercent;
	
	public static void main(String[] args) {
		Taxes tax = new Taxes();
		tax.taxPercentage(salary);
		tax.amountTaxed();
	}
	
	public float taxPercentage(float salary) {
		if (salary >= 0 && salary <= 14999) {
			taxPercent = 0;
		}
		else if (salary >= 15000 && salary <= 19999) {
			taxPercent = 10;
		}
		else if (salary >= 20000 && salary <= 29999) {
			taxPercent = 15;
		}
		else if (salary >= 30000 && salary <= 44999) {
			taxPercent = 20;
		}
		else {
			taxPercent = 25;
		}
		return taxPercent;
	}
	
	public float amountTaxed() {
		taxPercentage(salary);
		float amountTaxed = salary * taxPercent / 100;
		float remainingSalary = salary - amountTaxed;
		System.out.println("Salary: " + salary);
		System.out.println("Amount taxed: " + amountTaxed);
		System.out.println("Remaining Salary: " + remainingSalary);
		return amountTaxed;
	}
}
