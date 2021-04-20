package com.qa.firstApplication;
// SWITCH STATEMENTS
public class App4 {
	public static void main(String[] args) {
		switch1("Sunday");
		switch2("Monday");
	}
	
	public static void switch1(String today) {
		String day = today;
		
		switch (day) {
		case "Monday":
			System.out.println("Watch a film");
			break;
		case "Tuesday":
			System.out.println("Play a game");
			break;
		case "Wednesday":
			System.out.println("Eat a takeaway");
			break;
		case "Thursday":
			System.out.println("Have a pint");
			break;
		case "Friday":
			System.out.println("Play poker");
			break;
		case "Saturday":
			System.out.println("Sleep in");
			break;
		case "Sunday":
			System.out.println("Watch the race");
			break;
		default:
			System.out.println("Not a day, try again");
		}
	}
	
	public static void switch2(String today) {
		String day = today;
		
		switch (day) {
		case "Monday":
			System.out.println("I hate Mondays");
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
			System.out.println("Work");
			break;
		case "Saturday":
		case "Sunday":
			System.out.println("Party");
			break;
		default:
			System.out.println("Not a day, try again");
		}
	}
}
