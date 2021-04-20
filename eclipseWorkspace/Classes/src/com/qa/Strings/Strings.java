package com.qa.Strings;

public class Strings {
	
	public static void main(String[] args) {
		Strings strings = new Strings();
		
		//strings.subStrings();
		System.out.println(strings.replace("Hey Hi How are you", "i", "O"));
	}
	public void subStrings() {
		String greeting = "Hey Hi How are you";
		
		//System.out.println(greeting.substring(0,1));
		
		for (int i = 0; i < greeting.length(); i++) {
			System.out.print(greeting.substring(i, i+1));
			
		}
	}
	// before is the character to replace
	// after is the character that replaces before
	public String replace(String sentence, String before, String after) {
		String outputSentence = "";
		
		System.out.println("Input sentence: " + sentence);
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.substring(i, i+1).equals(before)) {
				outputSentence += after;
			}
			else {
				outputSentence += sentence.substring(i, i+1);
			}
		}
		return "Output sentence: " + outputSentence;
	}
	
}