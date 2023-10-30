/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests the methods and constructors for TestPlanManager.
 * @author Kenny Howard 
 */
class TestPlanManagerTest {

	/**
	 * Tests TestPlanManager constructor.
	 */
	@Test
	void testTestPlanManager() {
		TestPlanManager test = new TestPlanManager();
		assertFalse(test.isChanged());
		assertEquals(test.getCurrentTestPlan().getTestCases().size(), 0); 
	}

	/**
	 * Test loadTestPlans method.
	 */
	@Test
	void testLoadTestPlans() {
		File file = new File("test-files/test-plans0.txt");
		TestPlanManager test = new TestPlanManager();
		test.loadTestPlans(file);
		assertEquals(test.getTestPlanNames().length, 3);
		assertEquals(test.getTestPlanNames()[0], "Failing Tests");
		assertEquals(test.getTestPlanNames()[1], "PackScheduler");
		assertEquals(test.getTestPlanNames()[2], "WolfScheduler");
	}

	/**
	 * Tests saveTestPlans method.
	 */
	@Test
	void testSaveTestPlans() {
		File file = new File("test-files/untitled.txt");
		TestPlanManager test = new TestPlanManager();
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		test.addTestPlan("test");
		test.addTestCase(c);
		test.saveTestPlans(file);
		TestPlanManager test2 = new TestPlanManager();
		test2.loadTestPlans(file);
		assertEquals(test.getTestPlanNames()[0], test2.getTestPlanNames()[0]);
	}

	/**
	 * Tests isChanged method.
	 */
	@Test
	void testIsChanged() {
		TestPlanManager test = new TestPlanManager();
		assertFalse(test.isChanged());
		assertThrows(IllegalArgumentException.class,
				() -> test.editTestPlan("Hello"));
		test.addTestPlan("test plan");
		test.editTestPlan("Hello");
		assertTrue(test.isChanged());
	}

	/**
	 * TestsaddTestPlan method.
	 */
	@Test
	void testAddTestPlan() {
		TestPlanManager test = new TestPlanManager();
		test.addTestPlan("test");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "test");
	}

	/**
	 * Tests getTestPlanNames method.
	 */
	@Test
	void testGetTestPlanNames() {
		TestPlanManager test = new TestPlanManager();
		test.addTestPlan("1");
		test.addTestPlan("2");
		test.addTestPlan("3");
		String[] array = new String[4];
		array[0] = "Failing Tests";
		array[1] = "1";
		array[2] = "2";
		array[3] = "3";
		assertEquals(array[0], test.getTestPlanNames()[0]);
		assertEquals(array[1], test.getTestPlanNames()[1]);
		assertEquals(array[2], test.getTestPlanNames()[2]);
		assertEquals(array[3], test.getTestPlanNames()[3]);
	}

	/**
	 * Tests setCurrentTestPlan method.
	 */
	@Test
	void testSetCurrentTestPlan() {
		TestPlanManager test = new TestPlanManager();
		test.addTestPlan("1");
		test.addTestPlan("2");
		test.addTestPlan("3");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "3");
		test.setCurrentTestPlan("2");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "2");
		test.setCurrentTestPlan("asdf");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
	}

	/**
	 * Tests getCurrentTestPlan method.
	 */
	@Test
	void testGetCurrentTestPlan() {
		TestPlanManager test = new TestPlanManager();
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
		test.addTestPlan("test");
		test.addTestPlan("test2");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "test2");
	}

	/**
	 * Tests editTestPlan method.
	 */
	@Test
	void testEditTestPlan() {
		TestPlanManager test = new TestPlanManager();
		assertThrows(IllegalArgumentException.class,
				() -> test.editTestPlan("This shouldn't work"));
		test.addTestPlan("test");
		test.editTestPlan("This should work");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "This should work");
		
	}

	/**
	 * Tests removeTestPlan method.
	 */
	@Test
	void testRemoveTestPlan() {
		TestPlanManager test = new TestPlanManager();
		test.addTestPlan("test");
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "test");
		test.removeTestPlan();
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "Failing Tests");

		
	}

	/**
	 * Tests addTestCase method.
	 */
	@Test
	void testAddTestCase() {
		TestPlanManager test = new TestPlanManager();
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		test.addTestCase(c);
		test.addTestPlan("test");
		assertThrows(IndexOutOfBoundsException.class,
				() -> test.getCurrentTestPlan().getTestCase(0).getTestDescription(), "Testing TestCase");
		test.addTestCase(c);
		assertEquals(test.getCurrentTestPlan().getTestCase(0).getTestDescription(), "Testing TestCase");
	}

	/**
	 * Test addTestResult method.
	 */
	@Test
	void testAddTestResult() {
		TestPlanManager test = new TestPlanManager();
		TestCase c = new TestCase("TestCase test", "Equivalence Class", "Testing TestCase", "These tests should pass.");
		test.addTestPlan("test");
		test.addTestCase(c);
		test.addTestResult(0, true, "actualResults");
		assertEquals(test.getCurrentTestPlan().getTestCase(0).getActualResultsLog(), "- PASS: actualResults\n");
	}

	/**
	 * Test clearTestPlans method.
	 */
	@Test
	void testClearTestPlans() {
		TestPlanManager test = new TestPlanManager();
		test.addTestPlan("1");
		test.addTestPlan("2");
		test.addTestPlan("3");
		test.clearTestPlans();
		assertEquals(test.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
		assertFalse(test.isChanged());
	}

}
