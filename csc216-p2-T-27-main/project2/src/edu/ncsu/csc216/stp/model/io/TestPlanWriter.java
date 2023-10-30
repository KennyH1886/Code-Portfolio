package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.PrintStream;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * Writes an existing list of TestPlans into a given file path. Each TestPlan, and
 * TestCases within those TestPlans, are processed into text. One half of
 * SystemTestPlan's file i/o system.
 * @author Kenny Howard 
 */
public class TestPlanWriter {
	
	/**
	 * Writes a SortedList of TestPlans with any TestCases
	 * @param file File to write to 
	 * @param sortedList list of testPlans to save to file
	 * @throws IllegalArgumentException if there is a caught exception
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> sortedList) {
		try {
			PrintStream write = new PrintStream(file);
			
			for(int i = 0; i < sortedList.size(); i++) {
				write.println("! " + sortedList.get(i).getTestPlanName());
				ISwapList<TestCase> cases = sortedList.get(i).getTestCases();
				for (int j = 0; j < cases.size(); j++) {
					write.println("# " + cases.get(j).getTestCaseId() + "," + 
								  cases.get(j).getTestType());
					write.println("* " + cases.get(j).getTestDescription());
					write.println("* " + cases.get(j).getExpectedResults());
					write.print(cases.get(j).getActualResultsLog());
				}
			}
			write.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
	
}
