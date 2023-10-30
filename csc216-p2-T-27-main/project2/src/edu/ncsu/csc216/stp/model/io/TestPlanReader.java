package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * With its only public method, TestPlanReader reads through text in a given file,
 * and processes it into a list of TestPlans for the program. It is one half of
 * SystemTestPlans file i/o system.
 * @author Kenny Howard 
 */
public class TestPlanReader {
	
	/**
	 * Creates and returns a SortedList of TestPlans from a given file.
	 * @param file file to read from 
	 * @return SortedList of TestPlans
	 * @throws IllegalArgumentException if the file does not exist or if there is an error processing
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		String text = "";
		SortedList<TestPlan> list = new SortedList<TestPlan>();
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			while (fileReader.hasNextLine()) {
				text += fileReader.nextLine() + "\n";
			}
			fileReader.close();
			Scanner textReader = new Scanner(text);
			if (text.indexOf('!') != 0) {
				textReader.close();
				throw new IllegalArgumentException("Unable to load file.");
			}
				text = text.substring(1).trim();
				textReader.useDelimiter("\\r?\\n?[!]");
			while (textReader.hasNext()) {
				TestPlan t = processTestPlan(textReader.next());
				list.add(t);
			}
			textReader.close();
			return list;
		} catch (FileNotFoundException e){
			throw new IllegalArgumentException("Unable to load file.");
		}
	
	}
	
	/**
	 * Processes and returns a TestPlan with the given string.
	 * @param testPlanText Data to be used to create test plan and cases
	 * @return the newly constructed TestPlan
	 */
	private static TestPlan processTestPlan(String testPlanText) {
		String line = testPlanText.trim();
		Scanner reader = new Scanner(line);
		TestPlan plan = new TestPlan(reader.nextLine());
		reader.useDelimiter("\\r?\\n?[#]");
		while (reader.hasNext()) {
			TestCase c = processTest(plan, reader.next());
			if (c != null) {
				plan.addTestCase(c);
			}
		}
		reader.close();
		return plan;
		
	}
	
	/**
	 * Processes and returns a TestCase with the given parameters.
	 * @param tp AbstractTestPlan that holds the TestCase 
	 * @param testCaseText string of data to use to create the TestCase
	 * @return the newly constructed TestCase
	 */
	private static TestCase processTest(AbstractTestPlan tp, String testCaseText) {
		String line = testCaseText.trim();
		Scanner reader = new Scanner(line);
		try {
			reader.useDelimiter("\\r?\\n?[-]");
			String caseInfo1 = reader.nextLine();
			String caseId = caseInfo1.substring(0, caseInfo1.indexOf(","));
			String caseType = caseInfo1.substring(caseInfo1.indexOf(",") + 1).trim();
			String caseInfo2 = reader.next().substring(1);
			String caseDescription = caseInfo2.substring(1, caseInfo2.lastIndexOf("*")).trim();
			String caseExpectedResults = caseInfo2.substring(caseInfo2.lastIndexOf("*") + 1).trim();
			TestCase c = new TestCase(caseId, caseType, caseDescription, caseExpectedResults);
			while (reader.hasNext()) {
				String result = reader.next();
				String pf = result.substring(0, result.indexOf(":")).trim();
				boolean status = false;
				if (pf.equals(TestResult.PASS)) {
					status = true;
				}
				String resultDescription = result.substring(result.indexOf(":") + 1).trim();
				c.addTestResult(status, resultDescription);
			}
			reader.close();
			return c;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}

