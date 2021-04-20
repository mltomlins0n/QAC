package com.qa.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	@Test
	public void addTest() {
		Calculator calc = new Calculator();
		assertEquals(42, calc.add(39,3));
	}
}
