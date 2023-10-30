/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * A custom Exception class with two constructors. The first sends to the parent class a custom
 * exception message. The second calls the first constructor with a pre-set message,
 * "Schedule conflict.".
 * @author Kenny Howard 
 */
public class ConflictException extends Exception {
	/** ID used for serialization. */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * Sends a ConflictException message to the parent class based 
	 * on a custom message parameter.
	 * @param message custom message
	 */
	public ConflictException(String message) {
		super(message);
	}
	
	/**
	 * Calls the first constructor with the default message, "Schedule conflict.".
	 */
	public ConflictException() {
		this("Schedule conflict.");
	}
}
