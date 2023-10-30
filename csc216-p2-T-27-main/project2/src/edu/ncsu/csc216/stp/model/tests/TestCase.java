package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ILog;
import edu.ncsu.csc216.stp.model.util.Log;
/**
 * This class represents an individual test case of a TestPlan. Has fields and corresponding
 * getters and setters for a TestCase's id, type, description and expected results. Has a
 * Log of TestResults to help track the actual results of the TestPlan to see if the
 * TestPlan the TestCase belongs to is passing.
 * @author Kenny Howard 
 */
public class TestCase {

	/** The id of the TestCase. */
	private String testCaseId;
	/** The TestCase's type. */
	private String testType;
	/** The description of the TestCase. */
	private String testDescription;
	/** The TestCase's expected results. */
	private String expectedResults;
	/** The TestPlan that owns the TestCase. */
	private TestPlan testPlan;
	/** A log of the test results. */
	private ILog<TestResult> testResults;
	
	/**
	 * Constructs TestCase and sets the relevant fields to the parameters of the constructor.
	 * Sets testPlan to null and creates an empty log of test results.
	 * @param testCaseId String id of the TestCase
	 * @param testType String type of the TestCase
	 * @param testDescription String description of the TestCase
	 * @param expectedResults String of the TestCase's expected Results
	 */
	public TestCase(String testCaseId, String testType, String testDescription, 
					String expectedResults) {
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
		testPlan = null;
		testResults = new Log<TestResult>();
	}
	/**
	 * Returns the id of the TestCase.
	 * @return testCaseId String id of the TestCase
	 */
	public String getTestCaseId() {
		return testCaseId;
	}
	
	/**
	 * Sets testCaseId to the given parameter. Throws an IllegalArgumentException if
	 * the parameter is null or an empty string.
	 * @param testCaseId String id of the TestCase
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	private void setTestCaseId(String testCaseId) {
		if ("".equals(testCaseId) || testCaseId == null) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testCaseId = testCaseId;
	}
	
	/**
	 * Returns the type of the TestCase.
	 * @return testType String type of the TestCase
	 */
	public String getTestType() {
		return testType;
	}
	
	/**
	 * Sets testType to the given parameter. Throws an IllegalArgumentException 
	 * if the parameter String is null or empty.
	 * @param testType String type of the TestCase
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	private void setTestType(String testType) {
		if ("".equals(testType) || testType == null) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testType = testType;
	}
	
	/**
	 * Returns the TestCase's description.
	 * @return testDescription String description of the TestCase
	 */
	public String getTestDescription() {
		return testDescription;
	}
	
	/**
	 * Sets testDescription to the given parameter. Throws an exception if
	 * the parameter description is null or an empty String.
	 * @param testDescription String description of the TestCase
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	private void setTestDescription(String testDescription) {
		if ("".equals(testDescription) || testDescription == null) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testDescription = testDescription;
	}
	
	/**
	 * Returns the expected results of the TestCase.
	 * @return expectedResults String details of the TestCase's expected results
	 */
	public String getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * Sets expectedResults to the given parameter. Throws an IllegalArgumentException
	 * if the parameter results are null or an empty string.
	 * @param expectedResults String details of the TestCase's expected results
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	private void setExpectedResults(String expectedResults) {
		if ("".equals(expectedResults) || expectedResults == null) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.expectedResults = expectedResults;
	}
	
	/**
	 * Adds a TestResult based on the parameters and adds it to the back of the testResults log.
	 * Throws an IllegalArgumentException if a TestResult was unable to be constructed.
	 * @param passing boolean value on whether the test passed or failed
	 * @param actualResults String holding details on the test results
	 * @throws IllegalArgumentException if TestResult was not constructed
	 */
	public void addTestResult(boolean passing, String actualResults) {
		try {
			testResults.add(new TestResult(passing, actualResults));
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	/**
	 * Returns the boolean value of the last value in the testResults log.
	 * If testResults is empty, the method automatically returns false.
	 * @return true if the last TestResult in the log is passing. False otherwise.
	 */
	public boolean isTestCasePassing() {
		if (testResults.size() == 0) {
			return false;
		}
		return testResults.get(testResults.size() - 1).isPassing();
	}
	
	/**
	 * Returns the status of the TestCase based on isTestCasePassing returning true or false
	 * @return "PASS" if the TestCase passes, "FAIL" otherwise
	 */
	public String getStatus() {
		if (isTestCasePassing()) {
			return TestResult.PASS;
		}
		else {
			return TestResult.FAIL;
		}
	}
	
	/**
	 * Creates a String form of the testResults log and returns it.
	 * @return String form of the testResults log
	 */
	public String getActualResultsLog() {
		String log = "";
	 	for (int i = 0; i < testResults.size(); i++) {
			log += "- " + testResults.get(i).toString() + "\n";
		}
		return log;
	}
	/**
	 * Sets testPlan to the parameter. Throws an IllegalArgumentException if the parameter is null.
	 * @param testPlan a TestPlan to set as the field
	 * @throws IllegalArgumentException if the testPlan parameter is null
	 */
	public void setTestPlan(TestPlan testPlan) {
		if (testPlan == null) {
			throw new IllegalArgumentException("Invalid test plan.");
		}
		this.testPlan = testPlan;
	}
	
	/**
	 * Returns the testPlan field.
	 * @return testPlan the testPlan that owns the TestCase
	 */
	public TestPlan getTestPlan() {
		return testPlan;
	}
	
	/**
	 * Returns a String form of the TestCase. Overrides default toString method.
	 * @return String form of TestCase
	 */
	@Override
	public String toString() {
		if (testResults.size() == 0) {
			return testCaseId + "," + testType + "\n* " + testDescription + "\n* " + expectedResults;
		}
		return testCaseId + "," + testType + "\n* " + testDescription + "\n* " + expectedResults
				+ "\n" + getActualResultsLog();
	}
	
}
