package edu.ncsu.csc216.stp.model.util;


/**
 * A linked-based list that keeps elements in sorted order. Uses Comparable's compareTo method to
 * sort the elements in the list. Has methods to add, remove and get elements in the list. Also
 * has methods to keep duplicates out of the list like contains.
 * @author Kenny Howard 
 * @param <E> generic type for SortedList
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** The First node of the sorted list. */
	private ListNode front;
	
	/** The size of the sorted list. */
	private int size;
	
	/**
	 * Constructs a new SortedList object and sets front to null and size to 0.
	 */
	public SortedList() {
		front = null;
		size = 0;
	}


	/**
	 * Adds and sorts the parameter element into the list. Overrides ISortedList's add method.
	 * @param element to be added into the list
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element is a duplicate of an element in the list
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if(contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element.");
		}
		
		if (front == null) {
			front = new ListNode(element, null);
			size++;
		}
		else if(front.data.compareTo(element) > 0) {
			front = new ListNode(element, front);
			size++;
		}
		else {
			ListNode current = front;
			while (current.next != null) {
				if (current.next.data.compareTo(element) < 0) {
					current = current.next;
					continue;
				}
				current.next = new ListNode(element, current.next);
				size++;
				return;
			}
			current.next = new ListNode(element, null);
			size++;
		}
		
	}


	/**
	 * Removes an element from the list and returns the element from the method.
	 * Overrides ISortedList's remove method.
	 * @param idx index of the element to be removed
	 * @return element of the list that was removed
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		ListNode current = front;
		for (int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		E element;
		if (idx == 0) {
			element = current.data;
			front = front.next;
			size--;
		}
		else {
			element = current.next.data;
			current.next = current.next.next;
			size--;
		}
		return element;
	}
	
	/**
	 * Checks the index so that it is not less than 0 or greater than size. Otherwise,
	 * the method will throw an IndexOutOfBoundsException
	 * @param idx index of an element in the list
	 * @throws IndexOutOfBoundsException if idx is less than 0 or greater than size
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}


	/**
	 * Checks to see if the parameter element is inside the list. It will return true if
	 * the element is in the list, otherwise it will return false. Overrides ISortedList's
	 * contains method.
	 * @param element the element to be checked for inside the list
	 * @return contains which holds a boolean value depending on if the element is found in the list
	 */
	@Override
	public boolean contains(E element) {
		boolean contains = false;
		for (int i = 0; i < size; i++) {
			if (get(i).equals(element)) {
				contains = true;
			}
		}
		return contains;
	}


	/**
	 * Returns the element at the parameter index.
	 * @param idx index of an element in the list
	 * @return element that is listed at the parameter index in the list
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		ListNode holder = front; 
		for (int i = 0; i < idx; i++) {
			holder = holder.next;
		}
		return holder.data;
		
	}


	/**
	 * Returns the size of the list.
	 * @return size int holding the size of the sorted list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Governs the node functionality of the SortedList. Has two fields to hold data
	 * and to reference a following ListNode object. Inner class of SortedList. 
	 * @author Raphael Phillips
	 * @author Charlie Whitaker
	 */
	private class ListNode {

		/** The element within the node. */
		E data;
		
		/** The node that follows the given ListNode object. */
		ListNode next;
		
		/** 
		 * Constructs a new ListNode and sets data to the parameter object and next
		 * to the parameter ListNode.
		 * @param e element to be added into the list
		 * @param next the following ListNode to be set as the following ListNode
		 */
		public ListNode(E e, ListNode next) {
			data = e;
			this.next = next;
			
		}
	
	}

}
