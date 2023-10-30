package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * TestPlan class creates the TestPlan object, has methods to add and compare TestPlans. 
 * Has access to the classes and fields of its superclass, AbstractTestPlan.
 * Implements Comparable through its compareTo method. It can also return a 2D String
 * array of information regarding its TestCase list.
 * @author kenny Howard 
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {

	/**
	 * Constructs TestPlan and calls the super constructor with the
	 * given testPlanName parameter. If testPlanName is equivalent to
	 * FailingTestList's FAILING_TEST_NAME constant, an IllegalArgumentException
	 * will be thrown.
	 * @param testPlanName name to assign to the plan
	 * @throws IllegalArgumentException if testPlanName is equal to FAILING_TEST_NAME
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		if (testPlanName.compareToIgnoreCase(FailingTestList.FAILING_TEST_NAME) == 0) {
			throw new IllegalArgumentException("Invalid name.");
		}
	}
	
	/**
	 * Returns a 2D String array form of the TestCase list. The array has three columns
	 * representing test case id, test type and test plan name respectively.
	 * Overrides AbstractTestPlan's abstract getTestCasesAsArray method.
	 * @return 2D String array form of the TestCase list
	 */
	@Override
	public String[][] getTestCasesAsArray() {
		String[][] array = new String [getTestCases().size()][3];	
		for (int i = 0; i < getTestCases().size(); i++) {
			array[i][0] = getTestCases().get(i).getTestCaseId();
			array[i][1] = getTestCases().get(i).getTestType();
			array[i][2] = getTestCases().get(i).getStatus();
		}
		return array;
	}
	
	
	/**
	 * Adds the parameter TestCase into the testCases list. If the method called
	 * inside addTestCase throws an exception, it will be passed into addTestCase.
	 * Overrides the AbstractTestPlan's addTestCase method.
	 * @param t the TestCase to be added into the testCases list
	 */
	@Override
	public void addTestCase(TestCase t) {
		t.setTestPlan(this);
		super.addTestCase(t);
	}
	
	/**
	 * Compares the test plan name of the parameter with its own test plan name.
	 * It will compare the Strings using Comparable's own compareTo method. The result
	 * will be returned from this method.
	 * @param t the TestPlan to compare to
	 * @return less than 0 if the parameter's name is greater, 0 if they are equal or
	 *         greater than 1 if the parameter's name is less
	 */
	public int compareTo(TestPlan t) {
		return getTestPlanName().compareToIgnoreCase(t.getTestPlanName());
	}
}
