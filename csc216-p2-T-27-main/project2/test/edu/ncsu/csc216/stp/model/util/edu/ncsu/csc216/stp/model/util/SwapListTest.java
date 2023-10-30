/**
 * 
 */
package edu.ncsu.csc216.stp.model.util.edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.util.SwapList;

/**
 * Tests SwapList class and its methods.
 * @author Kenny Howard 
 */
class SwapListTest {

	/**
	 * Tests SwapList constructor.
	 */
	@Test
	void testSwapList() {
		SwapList<Integer> l = new SwapList<Integer>();
		assertEquals(0, l.size());
	}

	/**
	 * Test add() method.
	 */
	@Test
	void testAdd() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(2);
		l.add(3);
		assertEquals(2, l.size());
		assertEquals(2, l.get(0));
		assertEquals(3, l.get(1));
		Exception e = assertThrows(NullPointerException.class, () -> l.add(null));
		assertEquals("Cannot add null element.", e.getMessage());
	}

	/**
	 * Tests remove() method.
	 */
	@Test
	void testRemove() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(2);
		l.add(3);
		assertEquals(2, l.size());
		assertEquals(2, l.remove(0));
		assertEquals(1, l.size());
		assertEquals(3, l.get(0));
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> l.remove(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> l.remove(-1));
		assertEquals("Invalid index.", e2.getMessage());
	}

	/**
	 * Tests moveUp method.
	 */
	@Test
	void testMoveUp() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		l.add(10);
		l.moveUp(3);
		assertEquals(4, l.get(2));
		assertEquals(3, l.get(3));
	}

	/**
	 * Tests moveDown method.
	 */
	@Test
	void testMoveDown() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		l.add(10);
		l.moveDown(3);
		assertEquals(5, l.get(3));
		assertEquals(4, l.get(4));
	}

	/**
	 * Tests moveToFront method.
	 */
	@Test
	void testMoveToFront() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.moveToFront(4);
		assertEquals(5, l.get(0));
		assertEquals(1, l.get(1));
		assertEquals(2, l.get(2));
		assertEquals(3, l.get(3));
		assertEquals(4, l.get(4));
	}

	/**
	 * Tests moveToBack method.
	 */
	@Test
	void testMoveToBack() {
		SwapList<Integer> l = new SwapList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.moveToBack(0);
		assertEquals(2, l.get(0));
		assertEquals(3, l.get(1));
		assertEquals(4, l.get(2));
		assertEquals(5, l.get(3));
		assertEquals(1, l.get(4));
	}

}
