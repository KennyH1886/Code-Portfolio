/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Tests TestPlanReader's one public method.
 * @author Kenny Howard 
 */
class TestPlanReaderTest {

	/** 
	 * Expected results of the getActualResultsLog method from the 
	 * first TestCase of the first TestPlan
	 */
	private static String actualResults = "- PASS: actual results\n- FAIL: actual results on\n" +
											"multiple lines\n- PASS: actual results\non three\nlines\n";

	
	/**
	 * Tests readTestPlanFile method.
	 */
	@Test
	void testReadTestPlanFile() {
		ISortedList<TestPlan> list = assertDoesNotThrow(() -> TestPlanReader.readTestPlansFile(new File("test-files/test-plans0.txt")));
		assertEquals("PackScheduler", list.get(0).getTestPlanName());
		assertEquals("WolfScheduler", list.get(1).getTestPlanName());
		TestCase c1 = list.get(1).getTestCase(0);
		assertEquals("test1", c1.getTestCaseId());
		assertEquals("Equivalence Class", c1.getTestType());
		assertEquals("description\nwith multiple lines", c1.getTestDescription());
		assertEquals("expected results\nwith multiple lines", c1.getExpectedResults());
		assertEquals(actualResults, c1.getActualResultsLog());
	}

}
