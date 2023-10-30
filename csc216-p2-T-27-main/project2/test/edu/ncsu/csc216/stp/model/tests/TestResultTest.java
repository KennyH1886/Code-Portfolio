/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the TestResult constructor and its methods.
 * @author Kenny Howard 
 */
class TestResultTest {

	/**
	 * Tests the TestResult constructor, the isPassing method and the getActualResults method.
	 */
	@Test
	void testTestResult() {
		TestResult f = new TestResult(false, "Testing failed result.");
		TestResult p = new TestResult(true, "Testing passed result.");
		assertFalse(f.isPassing());
		assertTrue(p.isPassing());
		assertEquals("Testing failed result.", f.getActualResults());
		assertEquals("Testing passed result.", p.getActualResults());
	}


	/**
	 * Tests the toString method.
	 */
	@Test
	void testToString() {
		TestResult f = new TestResult(false, "Testing failed result.");
		assertEquals("FAIL: Testing failed result.", f.toString());
	}

}
