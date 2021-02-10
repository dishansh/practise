package com.nationwide.codingtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NationwideTest {
	
	@Test
	public void testWhenArrayHasSingleDigitValues() {
		assertEquals(440865, Nationwide.findDifference(new int[] {1, 0, 3, 2, 5, 4}));
	}

	@Test
	public void testWhenArrayHasDoubleDigitValues() {
		assertEquals(209979, Nationwide.findDifference(new int[] {11, 10, 31}));
	}
	
	@Test
	public void testWhenArrayHasMixedDigitValues() {
		assertEquals(8299791, Nationwide.findDifference(new int[] {11, 10, 31, 9}));
	}

}
