/**
 * 
 */
package edu.ncsu.csc216.stp.model.util.edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.util.Log;

/**
 * Tests the Log class's methods.
 * @author Kenny Howard 
 */
class LogTest {

	/**
	 * Tests the Log constructor.
	 */
	@Test
	void testLog() {
		Log<Integer> log = new Log<Integer>();
		assertEquals(0, log.size());
		log.add(3);
		log.add(5);
		log.add(7);
		log.add(9);
		log.add(11);
		log.add(13);
		log.add(15);
		log.add(17);
		log.add(19);
		log.add(21);
		assertEquals(10, log.size());
	}

	/**
	 * Tests the add method.
	 */
	@Test
	void testAdd() {
		Log<Integer> log = new Log<Integer>();
		assertEquals(0, log.size());
		log.add(3);
		log.add(5);
		log.add(7);
		assertEquals(3, log.size());
		assertEquals(3, log.get(0));
		assertEquals(5, log.get(1));
		assertEquals(7, log.get(2));
		// Null element added throws an exception
		Exception e = assertThrows(NullPointerException.class, () -> log.add(null));
		assertEquals("Cannot add null element.", e.getMessage());
	}


}
