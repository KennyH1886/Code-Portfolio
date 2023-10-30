package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SwapList;
/**
 * An abstract superclass to TestPlan and FailiingTestList. It represents both through the name
 * of the test plan and by a SwapList of TestCases.
 * @author Kenny Howard 
 *
 */
public abstract class AbstractTestPlan {

	/** The name of the TestPlan or FailingTestList. */
	private String testPlanName;
	/** A swappable list of TestCases. */
	private ISwapList<TestCase> testCases;
	/** 
	 * Constructs an AbstractTestPlan object and sets testPlanName to the parameter of
	 * the constructor.
	 * @param testPlanName the name of the TestPlan or FailingTestList
	 */
	public AbstractTestPlan(String testPlanName) {
		setTestPlanName(testPlanName);
		testCases = new SwapList<TestCase>();
	}
	
	/**
	 * Sets the testPlanName to the parameter. Throws an IllegalArgumentException if
	 * the parameter is null or any empty string.
	 * @param testPlanName the name of the TestPlan or FailingTestList
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	public void setTestPlanName(String testPlanName) {
		if ("".equals(testPlanName) || testPlanName == null) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.testPlanName = testPlanName;
	}
	
	/**
	 * Returns the testPlanName field.
	 * @return testPlanName the name of the TestPlan or FailingTestList
	 */
	public String getTestPlanName() {
		return testPlanName;
	}
	/**
	 * Returns the list of TestCases.
	 * @return testCases a swappable list of TestCases
	 */
	public ISwapList<TestCase> getTestCases() {
		return testCases;
	}
	
		/**
		 * Adds the parameter TestCase into the testCases list. If the method called
		 * inside addTestCase throws an exception, it will be passed into addTestCase.
		 * @param t the TestCase to be added into the testCases list
		 */
	public void addTestCase(TestCase t) {
		testCases.add(t);
	}
	
	/**
	 * Removes the TestCase in the testCases list at the parameter index.
	 * Returns the removed TestCase. If the method called inside 
	 * removeTestCase throws an exception, it will be passed into removeTestCase.
	 * @param idx int index of where the TestCase to be removed is
	 * @return the TestCase that was removed from the list
	 */
	public TestCase removeTestCase(int idx) {
		return testCases.remove(idx);
	}
	
	/**
	 * Gets the TestCase in the testCases list at the 
	 * @param idx int that represents the location of the TestCase to get in the list
	 * @return the TestCase at the given index
	 */
	public TestCase getTestCase(int idx) {
		return testCases.get(idx);
	}
	
	/**
	 * Returns the number of failing TestCases that are inside the testCases list.
	 * @return num int amount of failing tests.
	 */
	public int getNumberOfFailingTests() {
		int failing = 0;
		for (int i = 0; i < testCases.size(); i++) {
			if (!testCases.get(i).isTestCasePassing()) {
				failing++;
			}
		}
		return failing;
	}
	
	/**
	 * Creates a TestResult with the latter two parameters and adds it to the TestCase
	 * at the given index in the testCases list.
	 * @param idx int that represents the location of the TestCase that gets a new TestResult
	 * @param passing boolean value to see if the TestCase has passed
	 * @param actualResults String holding details about the TestResults
	 */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		testCases.get(idx).addTestResult(passing, actualResults);
	}
	
	/**
	 * Returns a 2D String array form of TestCases. To be overridden by TestPlan
	 * and FailingTestList.
	 * @return a 2D String array form of TestCases
	 */
	public abstract String[][] getTestCasesAsArray();

	
	
	/**
	 * Using the fields in AbstractTestPlan, creates and returns a hashCode for AbstractTestPlan.
	 * Overrides default hashCode.
	 * @return hashCode int a hashcode for AbstractTestPlan.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testPlanName == null) ? 0 : testPlanName.hashCode());
		return result;
	}
	
	/**
	 * Compares AbstractTestPlan to the parameter by comparing the the testPlanName field. 
	 * Returns true if they are equivalent, otherwise false.
	 * @param obj the Object to compare with AbstractTestPlan
	 * @return true if o has the same testPlanName
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTestPlan other = (AbstractTestPlan) obj;
		if (testPlanName == null) {
			if (other.testPlanName != null)
				return false;
		} else if (testPlanName.compareToIgnoreCase(other.testPlanName) != 0)
			return false;
		return true;
	}
	
}
