/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * Tests TestPlanWriter's only method.
 * @author Kenny Howard 
 *
 */
class TestPlanWriterTest {

	/**
	 * Tests writeTestPlanFile method.
	 */
	@Test
	void testWriteTestPlanFile() {
		ISortedList<TestPlan> list = new SortedList<TestPlan>();
		TestPlan planOne = new TestPlan("TestPlan1");
		TestCase caseZero = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		caseZero.addTestResult(false, "actual results 0-1");
		TestCase caseOne = new TestCase("ID 1", "type 1", "description 1", "expected results 1");
		caseOne.addTestResult(true, "actual results 1-1");
		caseOne.addTestResult(false, "actual results 1-2");
		TestCase caseTwo = new TestCase("ID 2", "type 2", "description 2", "expected results 2");
		caseTwo.addTestResult(true, "actual results 2-1");
		caseTwo.addTestResult(true, "actual results 2-2");
		planOne.addTestCase(caseZero);
		planOne.addTestCase(caseOne);
		planOne.addTestCase(caseTwo);
		list.add(planOne);
		list.add(new TestPlan("TestPlan2"));
		assertDoesNotThrow(() -> TestPlanWriter.writeTestPlanFile(new File("test-files/actual_out.txt"), list));
		checkFiles("test-files/expected_out.txt", "test-files/actual_out.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
