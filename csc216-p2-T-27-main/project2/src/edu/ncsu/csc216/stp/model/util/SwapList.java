	package edu.ncsu.csc216.stp.model.util;
/**
 * An array-based list that can hold specific elements. The list includes methods
 * to add, remove and move elements within the array. Allows for duplicate elements 
 * within the list.
 * @author Kenny Howard 
 * @param <E> generic type for SwapList
 */
public class SwapList<E> implements ISwapList<E> {

	/** The initial maximum capacity of the list array. */
	private static final int INITIAL_CAPACITY = 10;
	/** An array of elements. */
	E[] list;
	/** Number of elements in the array. */
	int size;

	/**
	 * Constructs SwapList with an initial capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds an element at the end of the list. Increments size and
	 * calls checkCapacity to adjust the list's array as needed.
	 * Overrides ISwapList's add method.
	 * @param element the element to be added
	 * @throws NullPointerException if the parameter element is null
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		list[size] = element;
		size++;
		checkCapacity(size);
	}
	
	/**
	 * Checks if the size is equal to the array length. If so, creates a new array with length
	 * twice the size of the previous and places each element into the new array. Finally, the
	 * bigger array is set as list.
	 * @param size int number of elements in the array.
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int size) {
		if (size == list.length) {
			E[] newList = (E[]) new Object[size * 2];
			for (int i = 0; i < size; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}
	}

	/**
	 * Removes an element at a given index, then readjusts the array accordingly.
	 * Overrides ISwapList's remove method.
	 * @param idx int index of where the element to be removed is
	 * @return element the element that was removed from the list
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E element = list[idx];
		for (int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return element;
	}

	/**
	 * Throws IndexOutOfBoundsException if parameter is less than 0 or greater than size.
	 * @param idx index of where the element to be removed is
	 * @throws IndexOutOfBoundsException if parameter is less than 0 or greater than size
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	
	/**
	 * Moves an element up in the array list. Overrides ISwapList's moveUp method.
	 * @param idx int of the element to be moved
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
		if (idx == 0) {
			return;
		}
		E temp = list[idx - 1];
		list[idx - 1] = list[idx];
		list[idx] = temp;
		
	}

	/**
	 * Moves an element down in the array list. Overrides ISwapList's moveDown method.
	 * @param idx int of the element to be moved
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		if (idx == size - 1) {
			return;
		}
		E temp = list[idx + 1];
		list[idx + 1] = list[idx];
		list[idx] = temp;
	}

	/**
	 * Moves an element to the front in the array list. Overrides ISwapList's moveToFront method.
	 * @param idx int of the element to be moved
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		E[] newList = (E[]) new Object[list.length];
		newList[0] = list[idx];
		for (int i = 1; i <= idx; i++) {
			newList[i] = list[i - 1];
		}
		for (int i = idx + 1; i < size; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}

	/**
	 * Moves an element to the back in the array list. Overrides ISwapList's moveToBack method.
	 * @param idx int of the element to be moved
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		E[] newList = (E[]) new Object[list.length];
		newList[size - 1] = list[idx];
		for (int i = size - 2; i >= idx; i--) {
			newList[i] = list[i + 1];
		}
		for (int i = idx - 1; i >= 0; i--) {
			newList[i] = list[i];
		}
		
		list = newList;
		
	}

	/**
	 * Get the element located at the given index of the array. Overrides ISwapList's get method.
	 * @param idx int that represents the location of the element to get in the list
	 * @return element that is listed at the parameter index in the list
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}

	/**
	 * Returns the size of the list. Overrides ISwapList's size method.
	 * @return size int the amount of elements in the given array.
	 */
	@Override
	public int size() {
		return size;
	}
	
	
	
	
}
