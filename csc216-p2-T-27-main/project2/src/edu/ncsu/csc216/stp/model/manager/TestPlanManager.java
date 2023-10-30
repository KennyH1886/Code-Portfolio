package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * Class creates the TestPlanManger object,
 * TestPlanManager is the object that is used 
 * to alter test plans. 
 * @author Kenny Howard 
 *
 */
public class TestPlanManager {

	/**
	 * Used to track if a test has been changed
	 */
	private boolean isChanged;
	
	/**
	 * Used to store the currentTestPlan, this is the
	 * test plan that will be edited. 
	 */
	private AbstractTestPlan currentTestPlan;
	
	/**
	 * This is a list of all the failing tests
	 */
	private FailingTestList failingTestList;
	
	/**
	 * SortedList of test plans
	 */
	private ISortedList<TestPlan> testPlans;
	
	/**
	 * Constructs TestPlanManager and creates a new blank list of testPlans.
	 */
	public TestPlanManager() {
		clearTestPlans();
	}
	
	/**
	 * Loads the test plan from a file.
	 * @param testPlanFile file to load info from
	 */
	public void loadTestPlans(File testPlanFile) {
		ISortedList<TestPlan> plans = TestPlanReader.readTestPlansFile(testPlanFile);
		for (int i = 0; i < plans.size(); i++) {
			try {
				testPlans.add(plans.get(i));
			} catch (Exception e) {
				continue;
			}
		}
		setCurrentTestPlan("Failing List");
		getFailingTests();
		isChanged = true;
	}
	
	/**
	 * Saves the test plans to a file.
	 * @param testPlanFile file path to save to 
	 */
	public void saveTestPlans(File testPlanFile) {
		TestPlanWriter.writeTestPlanFile(testPlanFile, testPlans);
		isChanged = false;
	}
	
	/**
	 * Returns the isChanged boolean.
	 * @return isChanged value
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Adds the test plan to the list.
	 * @param testPlanName the name of the plan to add
	 * @throws IllegalArgumentException if the parameter name is equivalent to "Failing Tests" 
	 *         or the name is a duplicate of another TestPlan's name
	 */
	public void addTestPlan(String testPlanName) {
		if ("Failing Tests".equals(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (getTestPlanNames().length - 1 == 0) {
			try {
				testPlans.add(new TestPlan(testPlanName));
				setCurrentTestPlan(testPlanName);
				isChanged = true;
				getFailingTests();
			} catch(IllegalArgumentException e) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		else {
			TestPlan planToAdd = new TestPlan(testPlanName);
			for (int i = 0; i < testPlans.size(); i++) {
				if (testPlans.get(i).equals(planToAdd)) {
					throw new IllegalArgumentException("Invalid name.");
				}
			}
			testPlans.add(planToAdd);
			setCurrentTestPlan(testPlanName);
			isChanged = true;
			getFailingTests();
		}
	}
	
	/**
	 * Gets the names of the test plans in String array format.
	 * @return Array of the names of test plans
	 */
	public String[] getTestPlanNames() {
		String[] names = new String[testPlans.size() + 1];
		names[0] = failingTestList.getTestPlanName();
		for(int i = 1; i < testPlans.size() + 1; i++) {
			names[i] = testPlans.get(i - 1).getTestPlanName();
		}
		return names;
	}
	
	/**
	 * Re-sorts the FailingTest list.
	 */
	private void getFailingTests() {
		failingTestList.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			ISwapList<TestCase> cases = testPlans.get(i).getTestCases();
			for (int j = 0; j < cases.size(); j++) {
				if (!cases.get(j).isTestCasePassing()) {
					failingTestList.addTestCase(cases.get(j));
				}
			}
		}
	}
	
	/**
	 * Sets the currentTestPlan to the parameter.
	 * @param testPlanName testPlan to be set to current
	 */
	public void setCurrentTestPlan(String testPlanName) {
		boolean changed = false;
		for (int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				currentTestPlan = testPlans.get(i);
				changed = true;
			}
		}
		if (!changed) {
			currentTestPlan = failingTestList;
		}
		
	}
	
	/**
	 * Returns the current test plan.
	 * @return currentTestPlan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 * Edits the name of the current TestPlan. isChanged is set to true.
	 * Throws an exception if Failing Test is the current TestPlan, if a TestPlan
	 * is attempted to be renamed "Failing Tests", or if the new name is a duplicate
	 * of an existing TestPlan's name.
	 * @param testPlanName Test plan to edit
	 * @throws IllegalArgumentException if Failing Tests is the current TestPlan, a normal TestPlan
	 *         is attempted to be named FailingTests or if it is a duplicate name
	 */
	public void editTestPlan(String testPlanName) {
		if ("Failing Tests".equals(currentTestPlan.getTestPlanName())) {
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		}
		if ("Failing Tests".equals(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < getTestPlanNames().length; i++) {
			if (getTestPlanNames()[i].equalsIgnoreCase(testPlanName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		ISortedList<TestPlan> newTestPlans = new SortedList<TestPlan>();
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).equals(currentTestPlan)) {
				testPlans.get(i).setTestPlanName(testPlanName);
				currentTestPlan = testPlans.get(i);
			}
			newTestPlans.add(testPlans.get(i));
		}
		testPlans = newTestPlans;
		currentTestPlan.setTestPlanName(testPlanName);
		isChanged = true;
		getFailingTests();
	}
	
	/**
	 * Removes the current TestPlan from the list. Throws an exception if Failing Tests is
	 * the current TestPlan.
	 * @throws IllegalArgumentException if Failing Tests is the current TestPlan
	 */
	public void removeTestPlan() {
		if ("Failing Tests".equals(currentTestPlan.getTestPlanName())){
			throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(currentTestPlan.getTestPlanName())) {
				testPlans.remove(i);
				currentTestPlan = failingTestList;
				isChanged = true;
				getFailingTests();
			}
		}
		
		
	}
	
	/**
	 * Adds the test case to the list.
	 * @param testCase test case to be added
	 */
	public void addTestCase(TestCase testCase) {
		if (!"Failing Tests".equals(currentTestPlan.getTestPlanName())) {
			currentTestPlan.addTestCase(testCase);
			isChanged = true;
			getFailingTests();
		}
	}
	
	/**
	 * Adds testResults to a TestPlan.
	 * @param idx which test plan to add to 
	 * @param passing if it is passing or not 
	 * @param actualResult results of the program
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		currentTestPlan.getTestCases().get(idx).addTestResult(passing, actualResult);
		if (!passing) {
			getFailingTests();
		}
	}
	
	/**
	 * Sets all the lists to new empty lists.
	 */
	public void clearTestPlans() {
		testPlans = new SortedList<TestPlan>();
		failingTestList = new FailingTestList();
		currentTestPlan = failingTestList;
		isChanged = false;
	}
	
	
}
