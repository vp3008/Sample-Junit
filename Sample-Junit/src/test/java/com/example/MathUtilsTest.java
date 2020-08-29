package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*@TestInstance(Lifecycle.PER_CLASS) // Creates only 1 instance per class unlike the default way where a new instance
									// is created before calling each test method. In this case we can avoid making
									// the BeforeAll methods static
*/class MathUtilsTest {

	MathUtils mathUtils;

	/*
	 * @BeforeAll static void beforeAllInit() {// methods annotated with beforeAll
	 * need to be static because they are run // before the instance of this class
	 * is created System.out.println("This needs to run before all"); }
	 */

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up..");
	}

	@Test
	@DisplayName("Testing add method")
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
	
	@Test
	@Disabled//disables this test. skipped during execution
	@DisplayName("TDD method. Should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
}
