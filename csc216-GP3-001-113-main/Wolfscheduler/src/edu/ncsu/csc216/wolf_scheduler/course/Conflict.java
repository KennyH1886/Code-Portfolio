/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * A conflict interface tailored to the Activity class and its subclasses.
 * Has an abstract method checkConflict to check for conflicts between activities.
 * This method is overridden by Activity's similar method.
 * @author Kenny howard 
 */
public interface Conflict {
	
	/**
	 * Checks to see if there is a conflict.
	 * @param possibleConflictingActivity An activity that may be conflicting
	 * @throws ConflictException if it detects a conflict
	 */
	void checkConflict(Activity possibleConflictingActivity) throws ConflictException;
}
