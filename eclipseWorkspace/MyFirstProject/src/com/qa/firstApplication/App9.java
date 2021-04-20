package com.qa.firstApplication;
import java.util.ArrayList;
// ARRAYLISTS
public class App9 {
	public static ArrayList<String> row = new ArrayList<String>();
	
	public static void main(String[] args) {
		//printArrayList();
		//numArrayList();
		arrayListArrayList();
	}
	
	public static void printArrayList() {
		row.add("Mohammed");
		row.add("Martin");
		row.add("William");
		row.add("Dylan");
		row.add("Shaan");
		row.add("Chris");
		System.out.print("Removing ");
		System.out.println(row.get(4)); // get element at index
		row.remove(4); // remove element at index
		
		
		for (String person : row) {
			System.out.println(person);
		}
		System.out.println("ArrayList size: " + row.size());
	}
	
	public static void arrayListArrayList() {
		ArrayList<ArrayList<String>> classroom = new ArrayList<>();
		
		ArrayList<String> row1 = new ArrayList<>();
		ArrayList<String> row2 = new ArrayList<>();
		ArrayList<String> row3 = new ArrayList<>();
		
		row1.add("Rory");
		row1.add("Adam");
		row2.add("Alex");
		row2.add("Bartek");
		row3.add("James");
		row3.add("Kendrick");
		
		classroom.add(row1);
		classroom.add(row2);
		classroom.add(row3);
		
		for (ArrayList<String> row : classroom)
			for (String person : row) {
				System.out.println(person);
		}
		
	}
	
	public static void numArrayList() {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		
		marks.add(3);
		marks.add(50);
		marks.add(77);
		marks.add(64);
		
		//marks.remove(marks.indexOf(50)); // finds int "50" and removes it from wherever it is
		marks.remove((Object) 50); // treats "50" as an object and removes it
		
		System.out.println(marks);
		
	}
}
