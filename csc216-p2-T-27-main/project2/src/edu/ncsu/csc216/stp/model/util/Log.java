package edu.ncsu.csc216.stp.model.util;
/**
 * An array-based log that can hold specific elements. The log can have elements added into it 
 * but elements cannot be removed once they are in the log. Has additional methods for getting
 * elements with a parameter index and size.
 * @author Kenny Howard 
 * @param <E> generic type for Log
 */
public class Log<E> implements ILog<E> {

	/** An array of elements. */
	private E[] log;
	/** Number of elements in the log. */
	private int size;
	/** The initial maximum capacity of the log array. */
	private static final int INIT_CAPACITY = 10;
	
	/**
	 * Constructs Log list with an initial capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public Log() {
		log = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}

	/**
	 * Adds an element into the log at the end of the array. Increments size
	 * and checks if size is nearing the array's capacity. If so, creates a new
	 * array with the same elements but twice the size and sets it as the new log.
	 * Overrides ILog's add method.
	 * @param element the element to be added
	 * @throws NullPointerException if the parameter element is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		log[size] = element;
		size++;
		if (size == log.length) {
			E[] newLog = (E[]) new Object[size * 2];
			for (int i = 0; i < size; i++) {
				newLog[i] = log[i];
			}
			log = newLog;
		}
	}

	/**
	 * Gets an element in the log with the parameter index. Overrides ILog's get method.
	 * Throws an IndexOutOfBoundsException if the parameter index is less than 0 or greater
	 * than the size.
	 * @param idx int that represents the location of the element to get in the log
	 * @return element that is listed at the parameter index in the log
	 * @throws IndexOutOfBoundsException if idx is less than 0 or is greater than or equal to size
	 */
	@Override
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return log[idx];
	}

	/**
	 * Returns the size of the log. Overrides ILog's size method.
	 * @return size int the amount of elements in the log
	 */
	@Override
	public int size() {
		return size;
	}
	
}
