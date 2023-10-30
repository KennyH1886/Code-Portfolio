/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This test class only tests checkConflict. It tests whether certain activities
 * throw an exception. If they do, they will be asserted that they are thrown.
 * If not, they will be asserted that they are not thrown.
 * @author Kenny Howard 
 */
class ActivityTest {

	/**
	 * Tests the checkConflict.
	 * @throws ConflictException as part of assertion tests
	 */
	@Test
	void testCheckConflict() {
		Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330, 1445);
		Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "TH", 1330, 1445);
		Activity a3 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "M", 1330, 1445);
		Activity a4 = new Course("CSC 216", "Software Development Fundamentals", "601", 3, "sesmith5", "A", 0, 0);
		Activity a5 = new Course("CSC 216", "Software Development Fundamentals", "602", 3, "sesmith5", "A", 0, 0);
		Activity a6 = new Course("CSC 216", "Software Development Fundamentals", "003", 3, "sesmith5", "THF", 1230, 1345);
		// Tests that DO NOT conflict
		assertDoesNotThrow(() -> a1.checkConflict(a2));
		assertDoesNotThrow(() -> a2.checkConflict(a1));
		assertDoesNotThrow(() -> a4.checkConflict(a5));
		assertDoesNotThrow(() -> a1.checkConflict(a5));
		assertDoesNotThrow(() -> a1.checkConflict(a6));
		// Tests that DO conflict
		Exception e1 = assertThrows(ConflictException.class, () -> a1.checkConflict(a3));
	    assertEquals("Schedule conflict.", e1.getMessage());
		
	    Exception e2 = assertThrows(ConflictException.class, () -> a3.checkConflict(a1));
	    assertEquals("Schedule conflict.", e2.getMessage());
	    
	    Exception e3 = assertThrows(ConflictException.class, () -> a2.checkConflict(a6));
	    assertEquals("Schedule conflict.", e3.getMessage());
	}

}
