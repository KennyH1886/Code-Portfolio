
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Event is a class that acts as a holder and constructor of information regarding Events.
 * With Activity's fields, Event holds, returns, and sets title, meeting days, and meeting times
 * from start to finish. It also has an additional field of it's own, for details of the event.
 * @author Kenny Howard
 */
public class Event extends Activity {
	
	/** The details of the Event. */
	private String eventDetails;

	/**
	 * Constructs an Event object and sets the fields to the given parameters.
	 * @param title title of the Event (from Activity)
	 * @param meetingDays meeting day of the Event (from Activity)
	 * @param startTime start time of the Event (from Activity)
	 * @param endTime end time of the Event (from Activity)
	 * @param eventDetails the details of the Event
	 */
	public Event(String title, String meetingDays, int startTime, int endTime, String eventDetails) {
		super(title, meetingDays, startTime, endTime);
		setEventDetails(eventDetails);
	}

	/**
	 * Returns the Event's details
	 * @return eventDetails Event's details
	 */
	public String getEventDetails() {
		return eventDetails;
	}

	/**
	 * Sets the Event's details
	 * @param eventDetails Event's details
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setEventDetails(String eventDetails) {
		if (eventDetails == null) {
			throw new IllegalArgumentException("Invalid event details.");
		}
		this.eventDetails = eventDetails;
	}
	
	/**
	 * Checks if the meetingDays string has wrong letters or has too many of one letter.
	 * Called by Event's setMeetingDaysAndTime() method override.
	 * @param meetingDays string that holds what days of the week 
	 * @throws IllegalArgumentException if there's a duplicate letter or a letter that isn't a day
	 */
	private void dayCheck(String meetingDays) {
		if (meetingDays == null) { 
			return; // Ends the method. Will get exception thrown by Activity
		}
		int monCount = 0;
		int tueCount = 0;
		int wedCount = 0;
		int thuCount = 0;
		int friCount = 0;
		int satCount = 0;
		int sunCount = 0;
		for (int i = 0; i < meetingDays.length(); i++) {
			switch (meetingDays.charAt(i)) {
				case 'M':
					monCount++;
					break;
				case 'T':
					tueCount++;
					break;
				case 'W':
					wedCount++;
					break;
				case 'H':
					thuCount++;
					break;
				case 'F':
					friCount++;
					break;
				case 'S':
					satCount++;
					break;
				case 'U':
					sunCount++;
					break;
				default:
					throw new IllegalArgumentException("Invalid meeting days and times.");
			}
		}
		if (monCount > 1 || tueCount > 1 || wedCount > 1 || thuCount > 1 || friCount > 1 ||
		    satCount > 1 || sunCount > 1) {
			// If one of the days is detected more than once
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
	}
	
	/**
	 * Overrides Activity's setMeetingDaysAndTime method to call dayCheck to check for
	 * acceptable characters in meetingDays, then calls the parent method.
	 * @param meetingDays days of the week when the event meets
	 * @param startTime time when the event starts
	 * @param endTime time when the event ends
	 */
	@Override
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		dayCheck(meetingDays);
		super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}
	
	/**
	 * Returns a string representation of Event, separated by commas. Overrides original toString.
	 * @return String holding event fields separated by commas
	 */
	@Override
	public String toString() {
		return getTitle() + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime() + 
			   "," + eventDetails;
	}
	
	/**
	 * Returns an array holding two empty values, the Event title, and a meeting string.
	 * Overrides Activity's blank method.
	 * @return a four length array holding two empty values, title and meetingString.
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] array = {"", "", getTitle(), getMeetingString()};
		return array;
	}
	
	/**
	 * Returns an array holding two empty values, the Event title, two empty values,
	 * a meeting string and the Event details. Overrides Activity's blank method.
	 * @return a seven length array holding two empty values, title, two more empty values
	 *         meetingString and eventDetails
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] array = {"", "", getTitle(), "", "", getMeetingString(), getEventDetails()};
		return array;
	}
	
	/**
	 * Overrides Activity's isDuplicate method, casts the parameter Activity into an Event,
	 * and compares its title string with this Event. Returns true if both are the same,
	 * returns false otherwise.
	 * @param activity an Activity object to compare if it is an Event duplicate
	 * @return true/false value if Event and the parameter have the same title string
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		if (!(activity instanceof Event)) {
			return false;
		}
		Event dupli = (Event) activity;
		return this.getTitle().equals(dupli.getTitle());
	}

}
