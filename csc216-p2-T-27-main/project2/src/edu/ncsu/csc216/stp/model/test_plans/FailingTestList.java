/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;

/**
 * This Class represents the Failing List of TestCases that is the first in the list
 * of TestPlans. Has methods to add testCases and return testCase information. Does not
 * allow the name of "Failing Test" to be changed. Subclass of AbstractTestPlan.
 * @author Kenny Howard
 */
public class FailingTestList extends AbstractTestPlan {

	/** The name of FailingTestList. */
	public static final String FAILING_TEST_NAME = "Failing Tests";
	
	/** 
	 * Constructs FailingTestList by calling the super constructor with
	 * FAILING_TEST_NAME as the testPlanName parameter.
	 */
	public FailingTestList(){
		super(FAILING_TEST_NAME);
	}
	
	/**
	 * Adds a TestCase into the list of failing testCases. If the parameter
	 * TestCase is not failing, an IllegalArgumentException is thrown.
	 * Overrides AbstractTestPlan's addTestCase method.
	 * @param t the TestCase to be added into the failing testCase list
	 * @throws IllegalArgumentException if the parameter is not a failing TestCase
	 */
	@Override
	public void addTestCase(TestCase t) {
		if (t.getStatus().equals(TestResult.PASS)) {
			throw new IllegalArgumentException("Cannot add passing test case.");
		}
		super.addTestCase(t);
	}
	
	/**
	 * Sets the TestPlanName to the given parameter. If the parameter is anything but
	 * "Failing Tests" or the FAILING_TEST_NAME constant, an IllegalArgumentException
	 * is thrown. Overrides AbstractTestPlan's setTestName method.
	 * @param s String to set the testPlanName as
	 * @throws IllegalArgumentException if s does not hold "Failing Tests" or otherwise 
	 *         equivalent to the FAILING_TEST_NAME constant
	 */
	public void setTestPlanName(String s) {
		if (!s.equals(FAILING_TEST_NAME)) {
			throw new IllegalArgumentException("The Failing Tests list cannot be edited.");
		}
		super.setTestPlanName(s);
	}
	
	/**
	 * Returns a 2D String array form of FailingTestList. The array has three columns
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
			if (getTestCases().get(i).getTestPlan() == null) {
				array[i][2] = "";
			}
			else {
				array[i][2] = getTestCases().get(i).getTestPlan().getTestPlanName();
			}
		}
		return array;
	}
	
	/**
	 * Clears the list of TestCases.
	 */
	public void clearTests() {
		while(getTestCases().size() != 0) {
			getTestCases().remove(0);
		}
	}
	
	
}
