package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String output = "";
		
		for (int i = 0; i < input.length(); i++) {
			// I'm bad at string manipulation
		}
		
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		// e.g. (10, 8, 4)
		if (a >= b && b >= c) {
			if ((a - b) == (b - c)) {
				return true;
			}
			else {
				return false;
			}
		} // e.g. (2, 4, 6)
		else if (a <= b && b <= c) {
			if ((b - a) == (c - b)) {
				return true;
			}
			else {
				return false;
			}
		} // e.g. (10, 8, 20)
		else if (a >= b && b <= c) {
			if ((a - b == c - b)) {
				return true;
			}
			else {
				return false;
			}
		} // e.g. (4, 6, 2)
		else if (a <= b && b >= c) {
			if ((b - a == b - c)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int n) {
		String output = "";
		
		for (int i = 0; i < input.length(); i++) {
			if (input.substring(i, i+1).equals(input.length()/2)) {
				output += ""; // remove character
			}
			else {
				output += input.substring(i, i+1);
			}
		}
		return output;
	}
	


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int blockLength = 0;
		String currentChar, nextChar = "";
		
		for (int i = 0; i < input.length(); i++) {
			currentChar = input.substring(i, i+1);
			nextChar = input.substring(i+1, i+2);
			if (currentChar.equals(nextChar)) {
				blockLength++;
			}
		}
		
		return blockLength;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int amCount = 0;
		
		for (int i = 4; i < arg1.length(); i++) {
			//System.out.print(arg1.substring(i,i+3) + "/");
			if (arg1.substring(i-4,i).toLowerCase().equals("am ") ||
				    arg1.substring(i-4,i).toLowerCase().equals(" am ")) {
				amCount++;
			}
		}
		return amCount;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String output = "";
		if (arg1 % 3 == 0) {
			output = "fizz";
		}
		else if (arg1 % 5 == 0) {
			output = "buzz";
		}
		if (arg1 % 3 == 0 && arg1 % 5 ==0) {
			output = "fizzbuzz";
		}
		return output;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		String num1 = "";
		String num2 = "";
		String num3 = "";
		
		for (int i = 0; i < arg1.length(); i++) {
			num1 = arg1.substring(0,2);
			num2 = arg1.substring(3,5);
			num3 = arg1.substring(6,8);
		}
		// get each individual number
		String num1Digit1 = String.valueOf(num1.substring(0,1));
		String num1Digit2 = String.valueOf(num1.substring(1,2));
		
		// Concatenates, doesn't add, cant cast from string to int
		String num1Result = num1Digit1 + num1Digit2;
		
		//System.out.println(num1Result);
		
		return -1;
	}
}
