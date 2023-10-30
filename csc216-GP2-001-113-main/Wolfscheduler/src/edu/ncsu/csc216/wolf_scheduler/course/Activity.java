package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Activity is a parent class of Course and Event. It constructs an object holding values
 * that both Course and Event utilize and need. It can hold, set, and return title, 
 * meeting days and the meeting start and end time.
 * @author Kenny Howard
 */
public abstract class Activity {

	/** The limit by hour where a meeting time will be considered invalid. */
	private static final int UPPER_HOUR = 24;
	/** The limit by minute where a meeting time will be considered invalid. */
	private static final int UPPER_MINUTE = 60;
	/** Activity's title. */
	private String title;
	/** Activity's meeting days */
	private String meetingDays;
	/** Activity's starting time */
	private int startTime;
	/** Activity's ending time */
	private int endTime;
	
	/**
	 * Constructs an Activity object and sets title, meetingDays, startTime, endTime
	 * to the given parameters.
	 * @param title Title of Activity
	 * @param meetingDays the Activity's meeting days
	 * @param startTime the Activity's starting time
	 * @param endTime the Activity's ending time
	 */
	public Activity(String title, String meetingDays, int startTime, int endTime) {
        super();
        setTitle(title);
        setMeetingDaysAndTime(meetingDays, startTime, endTime);
    }

	/**
	 * Returns the title of Activity.
	 * @return title of the Activity
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of Activity.
	 * @param title the title to set
	 * @throws IllegalArgumentException if the title is null or empty
	 */
	public void setTitle(String title) {
		if (title == null || title.length() == 0) {
			throw new IllegalArgumentException("Invalid title.");
		}
		this.title = title;
	}
	
	/**
	 * Returns the meeting days of Activity.
	 * @return meetingDays of the Activity
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Returns the starting time of Activity.
	 * @return the startTime of the Activity
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the end time of Activity.
	 * @return the endTime of the Activity
	 */
	public int getEndTime() {
		return endTime;
	}


	/**
	 * Checks if the starting and ending times' hours and minutes are valid.
	 * Called by the setMeetingDaysAndTime() method.
	 * @param startTime time when the activity starts
	 * @param endTime time when the activity ends
	 * @throws IllegalArgumentException if endTime is less than start time and if the
	 *         start and ending hours and minutes are out of range
	 */
	private void timeCheck(int startTime, int endTime) {
		if (endTime < startTime) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		int startHour = startTime / 100;
		int startMin = startTime % 100;
		int endHour = endTime / 100;
		int endMin = endTime % 100;
		if (startHour < 0 || startHour >= UPPER_HOUR) { // Not within 0-23 range
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		if (startMin < 0 || startMin >= UPPER_MINUTE) { // Not within 0-59 range
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		if (endHour < 0 || endHour >= UPPER_HOUR) { // Not within 0-23 range
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		if (endMin < 0 || endMin >= UPPER_MINUTE) { // Not within 0-59 range
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		
	}

	/**
	 * Sets the meeting days of Activity and sets when Activity starts and ends.
	 * @param meetingDays days of the week when the activity meets
	 * @param startTime time when the activity starts
	 * @param endTime time when the activity ends
	 * @throws IllegalArgumentException if any of the parameters are invalid
	 */
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if (meetingDays == null || meetingDays.length() == 0) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		timeCheck(startTime, endTime); // Checks if both startTime and endTime are valid
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Converts time integer to a XX:XX AM/PM string
	 * @param time integer in military time format
	 * @return time string in XX:XX AM/PM format
	 */
	private String getTimeString(int time) {
		int hour = time / 100;
		int min = time % 100;
		String em = null; // holds either "PM" or "AM" depending on value below
		boolean pm = false;
		if (hour > 12) { // 1:00-11:59pm
			hour = hour - 12;
			pm = true;
		}
		else if (hour == 12) { // 12pm
			pm = true;
		}
		else if (hour == 0) { // 12am
			hour = 12;
		}
		String minString = null;
		if (min < 10) {
			minString = "0" + min;
		}
		else {
			minString = "" + min;
		}
		if (pm) {
			em = "PM";
		}
		else {
			em = "AM";
		}
		return "" + hour + ":" + minString + em;
	}

	/**
	 * Creates a string containing the meeting days and start and end time, in XX:XX AM/PM format.
	 * @return string holding meeting days and start and end times
	 */
	public String getMeetingString() {
		if ("A".equals(meetingDays)) {
			return "Arranged";
		}
		String sTime = getTimeString(startTime);
		String eTime = getTimeString(endTime);
		return meetingDays + " " + sTime + "-" + eTime;
	}
	
	/**
	 * Using all fields in Activity, creates a hashCode for Activity. Overrides default method.
	 * @return hashCode integer a hashCode for Activity
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/**
	 * Compares Activity to a parameter Object by comparing all fields. Overrides default method.
	 * @param obj the Object being compared
	 * @return boolean true if obj is equivalent to Activity on all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Returns a String array containing name, section, title and meeting string
	 * @return a 4 length String array holding name, section, title and meeting string
	 */
	public abstract String[] getShortDisplayArray();
	/**
	 * Returns a string array containing name, section, title, credits, instructor id,
	 * meeting string and an empty string.
	 * @return a 7 length String array holding name, section, title, credits, instructor id,
	 *         meeting string and an empty string.
	 */
	public abstract String[] getLongDisplayArray();
	
	/**
	 * Checks if the given parameter is a duplicate of this object. To be overridden by
	 * the Course and Event subclasses.
	 * @param activity an Activity object to compare if it is an Activity duplicate
	 * @return true/false value if Course and the parameter have the same name string
	 */
	public abstract boolean isDuplicate(Activity activity);
}