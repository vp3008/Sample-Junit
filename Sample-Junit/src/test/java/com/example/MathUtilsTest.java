package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/*@TestInstance(Lifecycle.PER_CLASS) // Creates only 1 instance per class unlike the default way where a new instance
									// is created before calling each test method. In this case we can avoid making
									// the BeforeAll methods static
*/class MathUtilsTest {

	MathUtils mathUtils;

	TestInfo testInfo;// info about the test
	TestReporter testReporter;// provides access to console logs

	/*
	 * @BeforeAll static void beforeAllInit() {// methods annotated with beforeAll
	 * need to be static because they are run // before the instance of this class
	 * is created System.out.println("This needs to run before all"); }
	 */

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag names " + testInfo.getTags());
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up..");
	}

	@Nested
	@Tag("Math")
	@DisplayName("Testing addition")
	class AddTest {// only passes if all of the test cases contained within are passed
		@Test
		@DisplayName("Testing positive addition")
		void testPositiveAdd() {
			int expected = 5;
			int actual = mathUtils.add(3, 2);
			assertEquals(expected, actual, () -> "Should return " + expected + " and returned " + actual);// passing a
																											// supplier
																											// here
																											// makes it
																											// lazy
																											// assert
																											// message
																											// in case
																											// our
																											// message
																											// needs to
																											// perform
																											// heavy
																											// string
																											// calculations
		}

		@Test
		@DisplayName("Testing negative addition")
		void testNegativeAdd() {
			int expected = -5;
			assertEquals(expected, mathUtils.add(-3, -2), "Return sum of negative numbers");
		}
	}

	@Test
	/*
	 * Conditional annotations. Only runs when condition satisfied.
	 * 
	 * @EnabledForJreRange() -- only runs in provided JRE range, disabled otherwise
	 * 
	 * @EnabledOnOs(OS.WINDOWS)// only runs on specified OS, disabled otherwise
	 * 
	 * @EnabledIfEnvironmentVariable()
	 * 
	 * @EnabledIfSystemProperty
	 */
	@Tag("Math")

	void testDivide() {

		boolean isServerUp = false;

		assumeTrue(isServerUp);// Will only execute the test if the server is up
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
	@Tag("Math")

	@DisplayName("Multiply method")
	void testMultiply() {

		/*
		 * System.out.println("Running " + testInfo.getDisplayName() +
		 * " with tag names " + testInfo.getTags());// will // print // to // console
		 */
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag names " + testInfo.getTags());
		// assertEquals(4, mathUtils.multiply(2, 2), "Should return the right product");
		assertAll(// runs all of the below cases, if any one fails, the test fails
				() -> assertEquals(4, mathUtils.multiply(2, 2)), () -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1)), () -> assertEquals(10, mathUtils.multiply(-2, -5)));
	}

	@RepeatedTest(3) // repeats the test 3 times
	@Tag("Cicle")
	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
		/*
		 * repetitionInfo.getCurrentRepetition();
		 * repetitionInfo.getTotalRepetitions();// get information about repetitions
		 */
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}

	@Test
	@Disabled // disables this test. skipped during execution
	@DisplayName("TDD method. Should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
}
