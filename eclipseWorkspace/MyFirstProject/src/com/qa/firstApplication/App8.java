package com.qa.firstApplication;
//ARRAYS
public class App8 {
	
	public static String[] row1 = {"Rory", "Adam"};
	public static String[] row2 = {"Alex", "Bartek", "Vin"};
	public static String[] row3 = {"James", "Kendrick", "Owain"};
	public static String[] row4 = {"Mohammed", "Martin", "William", "Dylan",
	         "Shaan", "Chris"};
	
	// 2D array - array of arrays
	public static String[][] classroom = {row1, row2, row3, row4};
	
	public static void main(String[] args) {
		//forLoop();
		//forEachLoop();
		//arrayOfArrays();
		testArray();
	}
	
	public static void forLoop() {
		for (int i = 0; i < row4.length; i++) {
			System.out.print(row4[i] + ", ");
		}
	}
	
	public static void forEachLoop() {
		for (String person : row4) {
			System.out.print(person + ", ");
		}
	}
	
	public static void arrayOfArrays() {
		//System.out.println(classroom[3][1]);
		
		// get each row in the classroom[][] array
		for (String[] row : classroom) {
			System.out.println(row); // Prints the RAM location of row[] elements
			// get each person in the row[] array
			for (String person : row) {
				System.out.print(person + ", ");
			}
		}
	}
	
	public static void testArray() {
		// 5 arrays, 6 elements per array
		String[][] testClassroom = new String[5][6];
		testClassroom[3][4] = "Owain";
		System.out.println(testClassroom[3][4]);
	}
	
}
