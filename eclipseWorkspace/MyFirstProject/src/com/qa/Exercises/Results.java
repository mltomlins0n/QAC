package com.qa.Exercises;

public class Results {
	static int biology = 10;
	static int chemistry = 120;
	static int physics = 150;
	static int total = biology + chemistry + physics;
	static int examsFailed = 0;
	
	public static void main(String[] args) {
		displayResults(biology, chemistry, physics);
		calculatePercentage(biology, chemistry, physics, examsFailed);
		displayPercentage(total, examsFailed);
	}
	
	public static int displayResults(int bioMark, int chemMark,
			                          int physMark) {
		
		System.out.println("The Biology mark is: " + bioMark);
		System.out.println("The Chemistry mark is: " + chemMark);
		System.out.println("The Physics mark is: " + physMark);
		System.out.println("The total mark is: " + total);
		
		return total;
	}
	
	public static void displayPercentage(int totalMark, int failCount) {
		totalMark = total;
		examsFailed = failCount;
		float percentage = (total * 100) / 450;
		
		System.out.println("The percentage is: " + percentage + "%");
		
		if (percentage < 60 || failCount > 0) {
			System.out.println("You failed");
		}
	}
	
	public static int calculatePercentage(int bioMark, int chemMark,
			                               int physMark, int failCount) {
		bioMark = biology;
		chemMark = chemistry;
		physMark = physics;
		failCount = examsFailed;
		
		float bioPercentage = (biology * 100) / 150;
		float chemPercentage = (chemistry * 100) / 150;
		float physPercentage = (physics * 100) / 150;
		
		if (bioPercentage < 60) {
			System.out.println("You failed Biology");
			failCount++;
		}
		if (chemPercentage < 60) {
			System.out.println("You failed Chemistry");
			failCount++;
		}
		if (physPercentage < 60) {
			System.out.println("You failed Physics");
			failCount++;
		}
		System.out.println("You failed " + failCount + " modules");
		return examsFailed;
	}
}
