package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils= new MathUtils();
		int expected = 5;
		int actual = mathUtils.add(3, 2);
		assertEquals(expected, actual, "The add method should add 2 numbers");
	}
	
	
	@Test
	void testComputeCircleRadius() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}
}
