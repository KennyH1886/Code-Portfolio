package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;
import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.course.Event;
import edu.ncsu.csc216.wolf_scheduler.io.ActivityRecordIO;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;
/**
 * Acts as a holder for two ArrayLists; one for a Course catalog holding a selection of available
 * Courses, while schedule is a more personal list of Activities. 
 * WolfScheduler also has various methods that govern editing and giving data related to both. 
 * @author Kenny Howard 
 */
public class WolfScheduler {

	/** ArrayList holding a catalog of Courses. */
	private ArrayList<Course> catalog;
	
	/** ArrayList holding a schedule of Activities. */
	private ArrayList<Activity> schedule;
	
	/** The title to the schedule. */
	private String title;
	
	/**
	 * A constructor for WolfScheduler. Sets schedule as an empty ArrayList. Title is set
	 * by default to "My Schedule". The catalog is configured through a method in
	 * CourseRecordIO that reads through the given file name.
	 * @param filename a filename holding a list of courses
	 * @throws IllegalArgumentException if readCourseRecords throws an exception
	 */
	public WolfScheduler(String filename) {
		schedule = new ArrayList<Activity>();
		title = "My Schedule";
		try {
			catalog = CourseRecordIO.readCourseRecords(filename);
		} catch (Exception iae){
			iae.getMessage();
		}
	}
	
	/**
	 * Creates a 2D array from catalog that holds a Course's name, section, and title in 
	 * each column. Returns a null array if catalog is empty.
	 * @return catalogArray a 2D array of a Course's name, section, and title based on catalog
	 */
	public String[][] getCourseCatalog() {
		String[][] catalogArray = new String[catalog.size()][3];
		if (catalog.size() == 0) { // Returns empty array if schedule is empty
			return catalogArray;
		}
		Course holder;
		for (int i = 0; i < catalog.size(); i++) {
			holder = catalog.get(i);
			catalogArray[i] = holder.getShortDisplayArray();
		}
		return catalogArray;
	}
	
	/**
	 * Creates a 2D array from schedule that holds an Activity's name, section, title and
	 * meetingDay in each column. Returns a null array if schedule is empty.
	 * @return scheduleArray a 2D array of a Activity's name, section, and title based on schedule
	 */
	public String[][] getScheduledActivities() {
		String[][] scheduleArray = new String[schedule.size()][4];
		if (schedule.size() == 0) { // Returns empty array if schedule is empty
			return scheduleArray;
		}
		Activity holder;
		for (int i = 0; i < schedule.size(); i++) {
			holder = schedule.get(i);
			scheduleArray[i] = holder.getShortDisplayArray();
		}
		return scheduleArray;
	}
	
	/**
	 * Creates a 2D array from schedule that holds, if applicable, an Activity's 
	 * name, section, title, max credits, instructor id, meeting information, and 
	 * event details. . 
	 * Returns a null string if schedule is empty.
	 * @return fullArray a 2D array that holds all of Activity's equivalent fields from schedule
	 */
	public String[][] getFullScheduledActivities() {
		String[][] fullArray = new String[schedule.size()][7];
		if (schedule.size() == 0) { // Returns empty array if schedule is empty
			return fullArray;
		}
		Activity holder;
		for (int i = 0; i < schedule.size(); i++) {
			holder = schedule.get(i);
			fullArray[i] = holder.getLongDisplayArray();		
		}
		return fullArray;
	}
	
	/**
	 * Finds and returns a Course in the catalog using a given name and section.
	 * If the Course is not found, the method will return null instead.
	 * @param name String of a Course's name
	 * @param section String of a Course's section
	 * @return Either a Course based on the given parameters or null.
	 */
	public Course getCourseFromCatalog(String name, String section) {
		String nameHolder;
		String sectionHolder;
		for (int i = 0; i < catalog.size(); i++) {
			nameHolder = catalog.get(i).getName();
			sectionHolder = catalog.get(i).getSection();
			if (name.equals(nameHolder) && section.equals(sectionHolder)) {
				return catalog.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Finds a Course in catalog with a given name and section, and adds it to the schedule.
	 * If a Course is found and added successfully, returns true. Otherwise, returns false.
	 * @param name String of a Course's name
	 * @param section String of a Course's section
	 * @return boolean value based on if the Course is found in catalog and placed into schedule
	 * @throws IllegalArgumentException if the Course is already found in schedule
	 */
	public boolean addCourseToSchedule(String name, String section) {
		String nameHolder;
		String sectionHolder;
		for (int i = 0; i < catalog.size(); i++) {
			nameHolder = catalog.get(i).getName();
			sectionHolder = catalog.get(i).getSection();
			if (name.equals(nameHolder) && section.equals(sectionHolder)) {
				for (int j = 0; j < schedule.size(); j++) {
					if (catalog.get(i).isDuplicate(schedule.get(j))) {
						throw new IllegalArgumentException("You are already enrolled in " + name);
					}
				}
				schedule.add(catalog.get(i));
				return true;
			}
		}
		return false;
	}
	/**
	 * Creates a new Event based on the parameters and checks if there is a similar Event through
	 * the isDuplicate() method. If there is no duplicate, the Event is added to schedule and the
	 * method returns true. Else, it throws an IllegalArgumentException.
	 * @param title the Event's title
	 * @param meetingDays the meeting days of the Event
	 * @param startTime the starting time of the Event
	 * @param endTime the end time of the Event
	 * @param eventDetails the details of the Event
	 * @return true value if the Event is successfully added to schedule
	 * @throws IllegalArgumentException if isDuplicate returns true
	 */
	public boolean addEventToSchedule(String title, String meetingDays, int startTime, int endTime, String eventDetails) {
		Event ev = new Event(title, meetingDays, startTime, endTime, eventDetails);
		for (int i = 0; i < schedule.size(); i++) {
			if (ev.isDuplicate(schedule.get(i))) {
				throw new IllegalArgumentException("You have already created an event called " + ev.getTitle());
			}
		}
		schedule.add(ev);
		return true;
	}
	
	/**
	 * Finds a Course in schedule with a given name and section, and removes it.
	 * If a Course is found and removed successfully, returns true. Otherwise, returns false.
	 * @param idx index of the schedule where the to be removed Activity is
	 * @return boolean value based on if the Course is found in schedule
	 */
	public boolean removeActivityFromSchedule(int idx) {
		try {
			schedule.remove(idx);
			return true;
		} catch (Exception index) {
			return false;
		}
	}
	
	/**
	 * Resets schedule back to an empty ArrayList.
	 */
	public void resetSchedule() {
		schedule = new ArrayList<Activity>();
	}
	
	/**
	 * Returns the schedule's title.
	 * @return title String of the schedule's title
	 */
	public String getScheduleTitle() {
		return title;
	}
	
	/**
	 * Sets the schedule's title as the parameter.
	 * @param title String of the schedule's title
	 * @throws IllegalArgumentException if the parameter title is null
	 */
	public void setScheduleTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		this.title = title;
	}
	
	/**
	 * Exports a schedule to CourseRecordIO to be written into a file.
	 * @param filename that will hold a student's schedule
	 * @throws IllegalArgumentException if writeCourseRecords throws an exception
	 */
	public void exportSchedule(String filename) {
		try {
			ActivityRecordIO.writeActivityRecords(filename, schedule);
		} catch (Exception iae) {
			throw new IllegalArgumentException("This file cannot be saved.");
		}
	}

}
