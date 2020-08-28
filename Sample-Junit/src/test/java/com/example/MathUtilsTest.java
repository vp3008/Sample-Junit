package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	MathUtils mathUtils;

	@BeforeAll
	static void beforeAllInit() {// methods annotated with beforeAll need to be static because they are run
									// before the instance of this class is created
		System.out.println("This needs to run before all");
	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up..");
	}

	@Test
	void testAdd() {
		int expected = 5;
		int actual = mathUtils.add(3, 2);
		assertEquals(expected, actual, "The add method should add 2 numbers");
	}

	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by 0 should throw");// fails when
																											// the wrong
																											// exception
																											// type is
																											// specified
																											// or if
																											// there is
																											// no
																											// exception
	}

	@Test
	void testComputeCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}
}
