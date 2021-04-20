package com.qa.Exercises;

public class Conditionals {
	public static void main(String[] args) {
		Conditionals cond = new Conditionals();
		System.out.println(cond.conditionalMethod(40, 2, true));
		//cond.flowchartA(701);
	}
	
	public int conditionalMethod(int a, int b, boolean bool) {
		if (a % 2 == 0 || b % 2 == 0) {
			return 0;
		}
		if (bool) {
			return a + b;
		}
		else {
			return a * b;
		}
	}
	
	public void flowchartA(int a) {
	    if (a > 2000) {
	    	System.out.println("A");
	    }
		else if (a > 6000) {
			System.out.println("C");
		}
		else if (a > 4000 && a < 6000) {
			System.out.println("D");
		}
		else if (a > 2000 && a < 4000) {
				System.out.println("E");
		}
	    
	    if (a < 2000) {
	    	System.out.println("1");
	    }
	    if (a < 100) {
	    	System.out.println("2");
	    }
	    else {
	    	System.out.println("3");
	    }
	    if (a < 600) {
	    	System.out.println("4");
	    }
	    if (a > 500 && a < 600) {
	    	System.out.println("6");
	    }
	    else if (a < 500 && a > 100){
	    	System.out.println("7");
	    }
	    else { // over 600
	    	System.out.println("5");
	    }
	}
}
