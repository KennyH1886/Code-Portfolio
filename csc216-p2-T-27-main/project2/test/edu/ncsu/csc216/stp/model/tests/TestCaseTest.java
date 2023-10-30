/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test file for testing TestCase constructor and methods. 
 * @author Kenny Howard 
 */
class TestCaseTest {

	/**
	 * Tests TestCase constructor and getters.
	 */
	@Test
	void testTestCase() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		assertEquals("TestCase test", c.getTestCaseId());
		assertEquals("Equivalence Class", c.getTestType());
		assertEquals("Testing TestCase", c.getTestDescription());
		assertEquals("These tests should pass.", c.getExpectedResults());
		// Null parameters
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestCase(null, 
					   "Equivalence Class", "Testing TestCase", "This test should throw an Exception."));
		assertEquals("Invalid test information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test2", 
						null, "Testing TestCase", "This test should throw an Exception."));
		assertEquals("Invalid test information.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test3", 
					   "Equivalence Class", null, "This test should throw an Exception."));
		assertEquals("Invalid test information.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test4", 
				   "Equivalence Class", "Testing TestCase", null));
		assertEquals("Invalid test information.", e4.getMessage());
		// Empty parameters
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new TestCase("", 
				   "Equivalence Class", "Testing TestCase", "This test should throw an Exception."));
		assertEquals("Invalid test information.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test6", 
				null, "Testing TestCase", "This test should throw an Exception."));
		assertEquals("Invalid test information.", e6.getMessage());
		Exception e7 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test7", 
				"Equivalence Class", "", "This test should throw an Exception."));
		assertEquals("Invalid test information.", e7.getMessage());
		Exception e8 = assertThrows(IllegalArgumentException.class, () -> new TestCase("Test7", 
				"Equivalence Class", "Testing TestCase", ""));
		assertEquals("Invalid test information.", e8.getMessage());
	}


	/**
	 * Tests addTestResult method.
	 */
	@Test
	void testAddTestResultAndTestCasePassing() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		assertFalse(c.isTestCasePassing());
		c.addTestResult(false, "Testing failed.");
		assertFalse(c.isTestCasePassing());
		c.addTestResult(true, "Testing passed.");
		assertTrue(c.isTestCasePassing());
	}

	/**
	 * Tests getStatus method.
	 */
	@Test
	void testGetStatus() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		c.addTestResult(false, "Testing failed.");
		assertEquals(TestResult.FAIL, c.getStatus());
		c.addTestResult(true, "Testing passed.");
		assertEquals(TestResult.PASS, c.getStatus());
	}

	/**
	 * Tests getActualResultsLog method.
	 */
	@Test
	void testGetActualResultsLog() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		c.addTestResult(false, "Testing failed.");
		assertEquals("- FAIL: Testing failed.\n", c.getActualResultsLog());
	}

	/**
	 * Tests setTestPlan and getTestPlan method.
	 */
	@Test
	void testSetAndGetTestPlan() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		assertNull(c.getTestPlan());
		
	}



	/**
	 * Tests toString method.
	 */
	@Test
	void testToString() {
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		String expected = "TestCase test,Equivalence Class\n* Testing TestCase\n* These tests should pass.";
		assertEquals(expected, c.toString());
	}

}
