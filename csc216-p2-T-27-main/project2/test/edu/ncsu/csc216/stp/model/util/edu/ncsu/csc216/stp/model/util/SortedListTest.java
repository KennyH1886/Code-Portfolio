/**
 * 
 */
package edu.ncsu.csc216.stp.model.util.edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.util.SortedList;


/**
 * Test file for testing SortedList constructor and methods.
 * @author Kenny Howard 
 */
class SortedListTest {

	/**
	 * Tests SortedList's constructor.
	 */
	@Test
	void testSortedList() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
	}

	/**
	 * Tests add method.
	 */
	@Test
	void testAdd() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		list.add("apple");
		list.add("brown");
		list.add("king");
		list.add("jello");
		list.add("dog");
		assertEquals(5, list.size());
		assertEquals("apple", list.get(0));
		assertEquals("brown", list.get(1));
		assertEquals("dog", list.get(2));
		assertEquals("jello", list.get(3));
		assertEquals("king", list.get(4));
	}

	/**
	 * Tests remove method.
	 */
	@Test
	void testRemove() {
		SortedList<String> list = new SortedList<String>();
		list.add("apple");
		list.add("brown");
		list.add("king");
		list.add("jello");
		assertEquals(4, list.size());
		list.remove(0);
		assertEquals(3, list.size());
		assertEquals("brown", list.get(0));
		assertEquals("jello", list.get(1));
		assertEquals("king", list.get(2));
		SortedList<String> list2 = new SortedList<String>();
		list2.add("banana");
		list2.add("apple");
		list2.add("orange");
		list2.add("eggplant");
		assertEquals("banana", list2.remove(1));
	}

	/**
	 * Tests contains method.
	 */
	@Test
	void testContains() {
		SortedList<String> list = new SortedList<String>();
		list.add("apple");
		list.add("brown");
		assertTrue(list.contains("apple"));
		assertFalse(list.contains("banana"));
	}

}
