package com.qa.javaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.javaAssessment.Assessment;

public class AssessmentTest {
	/*
	 * README Do not edit tests, the trainer will be running your code against a
	 * copy of the current tests here. So if you edit the tests here, the changes
	 * will not reflect in the trainers version of the tests, and may result in some
	 * tests failing.
	 */
	Assessment oe = new Assessment();

	@Test
	public void multCharTest() {
		assertEquals("TTThhheee", oe.multChar("The"));
		assertEquals("AAAAAAbbbbbb", oe.multChar("AAbb"));
		assertEquals("HHHiii---TTThhheeerrreee", oe.multChar("Hi-There"));
	}

	@Test
	public void getBertTest() {
		assertFalse("Are you returning the right thing?", oe.getBert("bertclivebert").equals(""));
		assertFalse("Close! Now reverse the word", oe.getBert("bertclivebert").equals("clive"));
		assertEquals("evilc", oe.getBert("bertclivebert"));
		assertFalse("You to reverse the text between bert, not just remove the words 'bert'", oe.getBert("xxbertfridgebertyy").equals("yyegdirfxx"));
		assertEquals("egdirf", oe.getBert("xxbertfridgebertyy"));
		assertEquals("egdirf", oe.getBert("xxBertfridgebERtyy"));
		assertEquals("", oe.getBert("xxbertyy"));
		assertEquals("", oe.getBert("xxbeRTyy"));
	}

	@Test
	public void evenlySpacedTest() {
		assertTrue("Are you returning the right thing?", oe.evenlySpaced(2, 4, 6));
		assertTrue("Try sort the inputs by size then apply the same logic", oe.evenlySpaced(4, 6, 2));
		assertFalse(oe.evenlySpaced(4, 6, 3));
		assertFalse(oe.evenlySpaced(4, 60, 9));
	}

	@Test
	public void nMidTest() {
		assertFalse("Are you returning the right thing?", oe.nMid("Hello", 3).equals(""));
		assertEquals("The 3 middle letters are ell, which need to be removed", "Ho", oe.nMid("Hello", 3));
		assertEquals("Choate", oe.nMid("Chocolate", 3));
		assertEquals("Choclate", oe.nMid("Chocolate", 1));
	}
	
	@Test
	public void superBlockTest() {
		assertFalse("Are you returning the right thing?", oe.superBlock("hoopplla")==-1);
		assertEquals(2, oe.superBlock("hoopplla"));
		assertEquals(3, oe.superBlock("abbCCCddDDDeeEEE"));
		assertEquals(0, oe.superBlock(""));
	}
	
	@Test
	public void amISearchTest() {
		assertFalse("Are you returning the right thing?", oe.amISearch("Am I in Amsterdam") == -1);
		assertEquals("Have you tried applying multiple different conditions?", 1, oe.amISearch("Am I in Amsterdam"));
		assertEquals("Have you tried applying multiple different conditions?", 2, oe.amISearch("I am in Amsterdam am I?"));
		assertEquals("Have you tried applying multiple different conditions?",0, oe.amISearch("I have been in Amsterdam"));
		assertEquals("Have you tried applying multiple different conditions?",5, oe.amISearch("am am am amamam am am amuyg"));
		
	}
	
	@Test
	public void fizzBuzzTest() {
		assertNotNull("Are you returning the right thing?", oe.fizzBuzz(9));
		assertEquals("fizz", oe.fizzBuzz(9));
		assertEquals("buzz", oe.fizzBuzz(10));
		assertEquals("fizzbuzz", oe.fizzBuzz(30));
		assertEquals("fizzbuzz", oe.fizzBuzz(3000));
		
	}
	
	@Test
	public void largestTest() {
		assertFalse("Are you returning the right thing?", oe.largest("55 72 86") == -1);
		assertEquals(14,oe.largest("55 72 86"));
		assertEquals(11,oe.largest("15 72 80 164"));
		assertEquals(15,oe.largest("555 72 86 45 10"));
		
	}

}
