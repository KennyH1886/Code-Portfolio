package edu.ncsu.csc216.stp.model.tests;
/**
 * This class represents the results of a TestCase. Has fields and corresponding getters and
 * setters for a boolean field determining if the test passed or failed and for a String holding
 * details about the results. Also has a toString method for a String representation of the method.
 * @author Kenny Howard 
 */
public class TestResult {

	/** String representation of a passing test. */
	public static final String PASS = "PASS";
	/** String representation of a failing test. */
	public static final String FAIL = "FAIL";
	/** Boolean holding value on if the test is passing or failing. */
	private boolean passing;
	/** String holding text about the actual results of the test. */
	private String actualResults;
	/**
	 * Constructs a TestResult object and sets the fields to the parameters.
	 * @param passing boolean that determines if the test passed or failed
	 * @param actualResults String holding details about the results
	 */
	public TestResult(boolean passing, String actualResults) {
		setPassing(passing);
		setActualResults(actualResults);
	}
	
	/**
	 * Returns the actualResults of the test result.
	 * @return actualResults String holding details about the results
	 */
	public String getActualResults() {
		return actualResults;
	}
	
	/**
	 * Sets the actualResults field to the parameter. Throws an IllegalArgumentException if
	 * actualResults is null or an empty string.
	 * @param actualResults String holding details about the results
	 * @throws IllegalArgumentException if the parameter is null or an empty string
	 */
	private void setActualResults(String actualResults) {
		if ("".equals(actualResults) || actualResults == null) {
			throw new IllegalArgumentException("Invalid test results.");
		}
		this.actualResults = actualResults;
	}
	
	/**
	 * Returns the boolean value on whether the test is passing or failing.
	 * @return passing boolean that determines if the test passed or failed
	 */
	public boolean isPassing() {
		return passing;
	}
	
	/**
	 * Sets the passing field to the parameter.
	 * @param passing boolean that determines if the test passed or failed
	 */
	private void setPassing(boolean passing) {
		this.passing = passing;
	}
	
	/**
	 * Returns a String representation of TestResult based on the values of its fields.
	 * Overrides default toString method.
	 * @return String representation of TestResult
	 */
	@Override
	public String toString() {
		String pf = FAIL;
		if (passing) {
			pf = PASS;
		}
		return pf + ": " + actualResults;
	}
	
}
