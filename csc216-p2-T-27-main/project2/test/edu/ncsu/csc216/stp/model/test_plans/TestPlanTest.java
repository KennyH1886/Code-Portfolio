/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests the TestPlan constructor and its methods.
 * @author Kenny Howard 
 */
class TestPlanTest {

	/**
	 * Tests the TestPlan constructor.
	 */
	@Test
	void testTestPlan() {
		TestPlan test = new TestPlan("name");
		TestPlan test2 = new TestPlan("name");
		assertThrows(IllegalArgumentException.class,
				() -> new TestPlan(""));
		assertEquals(test.getTestPlanName(), "name");
		assertThrows(IllegalArgumentException.class,
				() -> test.setTestPlanName(null));
		assertEquals(test.getTestPlanName(), "name");
		TestCase t = new TestCase("0", "true", "description", "expectedResults");
		test.addTestCase(t);
		test.addTestResult(0, true, "test");
		assertEquals(test.getTestCase(0).getActualResultsLog(), "- PASS: test\n");
		test.removeTestCase(0);
		assertEquals(test.getTestCases().size(), 0);
		assertTrue(test.equals(test2));
	}
	
	/**
	 * Tests the addTestCase method.
	 */
	@Test
	void testAddTestCase() {
		TestPlan test = new TestPlan("name");
		TestCase t = new TestCase("0", "true", "description", "expectedResults");
		test.addTestCase(t);
		assertEquals(test.getTestCase(0), t);
	}

	/**
	 * Tests the getTestCasesAsArray method.
	 */
	@Test
	void testGetTestCasesAsArray() {
		TestPlan test = new TestPlan("name");
		TestCase t = new TestCase("0", "test", "description", "expectedResults");
		test.addTestCase(t);
		assertEquals(test.getTestCasesAsArray()[0][0], "0");
		assertEquals(test.getTestCasesAsArray()[0][1], "test");
		assertEquals(test.getTestCasesAsArray()[0][2], "FAIL");
	}


	/**
	 * Tests the compareTo method.
	 */
	@Test
	void testCompareTo() {
		TestPlan test = new TestPlan("name");
		TestPlan test1 = new TestPlan("name");
		TestPlan test2 = new TestPlan("name2");
		assertEquals(test.compareTo(test2), -1);
		assertEquals(test.compareTo(test1), 0);
		
	}

}
