/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests FailingTestList constructor and its methods.
 * @author Kenny howard 
 */
class FailingTestListTest {

	/**
	 * Tests FailingTestList's constructor.
	 */
	@Test
	void testFailingTestList() {
		FailingTestList test = new FailingTestList();
		assertEquals(test.getTestPlanName(), "Failing Tests");		
	}
	
	/**
	 * Tests setTestPlanName method.
	 */
	@Test
	void testSetTestPlanName() {
		FailingTestList test = new FailingTestList();
		Exception e = assertThrows(IllegalArgumentException.class,
				() -> test.setTestPlanName("test"));
		assertEquals(e.getMessage(), "The Failing Tests list cannot be edited.");
	}

	/**
	 * Tests addTestCase method.
	 */
	@Test
	void testAddTestCase() {
		FailingTestList test = new FailingTestList();
		TestCase t = new TestCase("0", "true", "description", "expectedResults");
		test.addTestCase(t);
		assertEquals(test.getTestCase(0), t);
	}

	/**
	 * Tests getTestCasesAsArray method.
	 */
	@Test
	void testGetTestCasesAsArray() {
		FailingTestList test = new FailingTestList();
		TestCase t = new TestCase("0", "test", "description", "expectedResults");
		test.addTestCase(t);
		assertEquals(test.getTestCasesAsArray()[0][0], "0");
		assertEquals(test.getTestCasesAsArray()[0][1], "test");
		assertEquals(test.getTestCasesAsArray()[0][2], "");


	}
	
	@Test
	void testGetNumberOfFailingTest() {
		FailingTestList test = new FailingTestList();
		assertEquals(test.getNumberOfFailingTests(), 0);
		TestCase t = new TestCase("0", "test", "description", "expectedResults");
		test.addTestCase(t);
		test.addTestResult(0, false, "test");
		assertEquals(test.getNumberOfFailingTests(), 1);
	}


	/**
	 * Tests the clearTests method.
	 */
	@Test
	void testClearTests() {
		FailingTestList test = new FailingTestList();
		TestCase t = new TestCase("0", "true", "description", "expectedResults");
		test.addTestCase(t);
		test.clearTests();
		assertEquals(test.getTestCases().size(), 0);
	}

}
