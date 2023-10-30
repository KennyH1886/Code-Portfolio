/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This test class tests the custom exception, Conflict Exception. The first test tests the
 * constructor with a custom string message parameter. The second test tests the constructor
 * without any parameters.
 * @author Kenny Howard 
 */
class ConflictExceptionTest {

	/**
	 * Test method for ConflictException constructor with string parameter.
	 * @throws ConflictException as part of test
	 */
	@Test
	void testConflictExceptionString() {
		ConflictException ce = new ConflictException("Custom exception message");
	    assertEquals("Custom exception message", ce.getMessage());
	}

	/**
	 * Test method for ConflictException constructor with no parameter.
	 * @throws ConflictException as part of test
	 */
	@Test
	void testConflictException() {
		ConflictException ce = new ConflictException();
		assertEquals("Schedule conflict.", ce.getMessage());
	}

}
