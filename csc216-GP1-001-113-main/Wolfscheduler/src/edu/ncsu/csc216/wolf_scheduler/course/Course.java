package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * a "Course" class that acts as a container for various pieces of information
 * related to a course. It can store and provide access to details such as the
 * course name, title, section, credit hours, instructor's unity ID, meeting
 * days, and the start and end times. Additionally, the class includes methods
 * to compare whether two Course objects are equivalent.
 * 
 * @author Kenny Howard
 */
public class Course {
	/** Minimum Course name length. */
	private static final int MIN_NAME_LENGTH = 5;
	/** Maximum Course name length. */
	private static final int MAX_NAME_LENGTH = 8;
	/**
	 * Minimum Course letter length that represents the subject, i.e. CSC of CSC
	 * 216.
	 */
	private static final int MIN_LETTER_COUNT = 1;
	/**
	 * Maximum Course letter length that represents the subject, i.e. CSC of CSC
	 * 216.
	 */
	private static final int MAX_LETTER_COUNT = 4;
	/** Digit length that represents the course number, i.e. 216 of CSC 216. */
	private static final int DIGIT_COUNT = 3;
	/**
	 * Section length that represents the section number, i.e. section 001 of CSC
	 * 216.
	 */
	private static final int SECTION_LENGTH = 3;
	/** Maximum credit hours a course can be worth. */
	private static final int MAX_CREDITS = 5;
	/** Minimum credit hours a course can be worth. */
	private static final int MIN_CREDITS = 1;
	/** The limit by hour where a meeting time will be considered invalid. */
	private static final int UPPER_HOUR = 24;
	/** The limit by minute where a meeting time will be considered invalid. */
	private static final int UPPER_MINUTE = 60;
	/** Course's name. */
	private String name;
	/** Course's title. */
	private String title;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/** Course's meeting days */
	private String meetingDays;
	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	/**
	 * Constructs the object Course with parameters for all fields
	 * and sets them with the appropriate setters.
	 * 
	 * @param name         Course name
	 * @param title        Course title
	 * @param section      Course section
	 * @param credits      Course credit hours
	 * @param instructorId Unity ID of the instructor
	 * @param meetingDays  Days when the class meets
	 * @param startTime    Time when the class starts
	 * @param endTime      Time when the class ends
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		setName(name);
		setTitle(title);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
		setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}

	/**
	 * Constructs the object Course with parameters for the course name, title,
	 * section,
	 * credit hours, instructor id, and meeting days and sets them using the
	 * constructor
	 * with eight parameters.
	 * 
	 * @param name         Course name
	 * @param title        Course title
	 * @param section      Course section
	 * @param credits      Course credit hours
	 * @param instructorId Unity ID of the instructor
	 * @param meetingDays  Days when the class meets
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}

	/**
	 * Returns the name of Course.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Course. Checks multiple times to see if the name is
	 * invalid, whether
	 * by it being null, being too long or too short in length, not having a space
	 * between the
	 * letter and number parts of the name, and if the letters and numbers are too
	 * long or
	 * too short.
	 * 
	 * @param name the name to set
	 * @throws IllegalArgumentException if name is null or not within proper
	 *                                  parameters
	 */
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		int letterCount = 0;
		int digitCount = 0;
		boolean spaceFound = false;
		for (int i = 0; i < name.length(); i++) {
			if (!spaceFound) {
				if (Character.isLetter(name.charAt(i))) {
					letterCount++;
				} else if (name.charAt(i) == ' ') {
					spaceFound = true;
				} else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			} else if (spaceFound) {
				if (Character.isDigit(name.charAt(i))) {
					digitCount++;
				} else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			}
		}
		if (letterCount < MIN_LETTER_COUNT || letterCount > MAX_LETTER_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		if (digitCount != DIGIT_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		this.name = name;
	}

	/**
	 * Returns the title of Course.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of Course.
	 * 
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
	 * Returns the section number of Course.
	 * 
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets the section number of Course.
	 * 
	 * @param section the section to set
	 * @throws IllegalArgumentException if the section is null or doesn't have 3
	 *                                  digits
	 */
	public void setSection(String section) {
		if (section == null || section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException("Invalid section.");
		}
		for (int i = 0; i < SECTION_LENGTH; i++) {
			if (Character.isDigit(section.charAt(i))) {
				continue;
			} else {
				throw new IllegalArgumentException("Invalid section.");
			}
		}
		this.section = section;
	}

	/**
	 * Returns the credit hours of Course.
	 * 
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the credit hours of Course.
	 * 
	 * @param credits the credits to set
	 * @throws IllegalArgumentException if credits is less than 1 or greater than 5
	 */
	public void setCredits(int credits) {
		if (credits < MIN_CREDITS || credits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid credits.");
		}
		this.credits = credits;
	}

	/**
	 * Returns the instructor's unity ID of Course.
	 * 
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * Sets the instructor's unity ID of Course.
	 * 
	 * @param instructorId the instructorId to set
	 * @throws IllegalArgumentException if instructorId is null or empty
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null || instructorId.length() == 0) {
			throw new IllegalArgumentException("Invalid instructor id.");
		}
		this.instructorId = instructorId;
	}

	/**
	 * Returns the meeting days of Course.
	 * 
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Returns the starting time of Course.
	 * 
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the end time of Course.
	 * 
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Checks if the meetingDays string has wrong letters or has too many of one
	 * letter.
	 * Called by the setMeetingDaysAndTime() method.
	 * 
	 * @param meetingDays string that holds what days of the week
	 * @throws IllegalArgumentException if there's a duplicate letter or a letter
	 *                                  that isn't a day
	 */
	private void dayCheck(String meetingDays) {
		int monCount = 0;
		int tueCount = 0;
		int wedCount = 0;
		int thuCount = 0;
		int friCount = 0;
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
				default:
					throw new IllegalArgumentException("Invalid meeting days and times.");
			}
		}
		if (monCount > 1 || tueCount > 1 || wedCount > 1 || thuCount > 1 || friCount > 1) {
			// If one of the days is detected more than once
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
	}

	/**
	 * Checks if the starting and ending times' hours and minutes are valid.
	 * Called by the setMeetingDaysAndTime() method.
	 * 
	 * @param startTime time when the class starts
	 * @param endTime   time when the class ends
	 * @throws IllegalArgumentException if endTime is less than start time and if
	 *                                  the
	 *                                  start and ending hours and minutes are out
	 *                                  of range
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
	 * Sets the meeting days of Course and sets when Course starts and ends.
	 * 
	 * @param meetingDays days of the week when the class meets
	 * @param startTime   time when the class starts
	 * @param endTime     time when the class ends
	 * @throws IllegalArgumentException if any of the parameters are invalid
	 */
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if (meetingDays == null || meetingDays.length() == 0) {
			throw new IllegalArgumentException("Invalid meeting days and times.");
		}
		if ("A".equals(meetingDays)) { // "A" for Arranged
			if (startTime != 0 || endTime != 0) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			this.meetingDays = meetingDays;
			this.startTime = 0;
			this.endTime = 0;
		} else {
			dayCheck(meetingDays); // Checks if meetingDays is valid
			timeCheck(startTime, endTime); // Checks if both startTime and endTime are valid
			this.meetingDays = meetingDays;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	/**
	 * Converts time integer to a XX:XX AM/PM string
	 * 
	 * @param time integer in military time format
	 * @return time string in XX:XX AM/PM format
	 */
	private String getTimeString(int time) {
		int hour = time / 100;
		int min = time % 100;
		String em = null;
		boolean pm = false;
		if (hour > 12) {
			hour = hour - 12;
			pm = true;
		}
		String minString = null;
		if (min < 10) {
			minString = "0" + min;
		} else {
			minString = "" + min;
		}
		if (pm) {
			em = "PM";
		} else {
			em = "AM";
		}
		return "" + hour + ":" + minString + em;
	}

	/**
	 * Creates a string containing the meeting days and start and end time, in XX:XX
	 * AM/PM format.
	 * 
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
	 * Overrides the default hashCode method and makes a hashCode for the
	 * Course object that utilizes all fields.
	 * 
	 * @return result a hashCode for the Course object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + endTime;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Overrides the default equals method and compares this object to
	 * another given object based on the equality of each's fields.
	 * 
	 * @param obj the object that will be compared
	 * @return true if the fields of both objects are the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (endTime != other.endTime)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
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
	 * Overrides the default toString method and returns a comma separated value
	 * String of all Course fields. If the meeting days are arranged, omits starting
	 * and end time.
	 * 
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if ("A".equals(meetingDays)) {
			return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays;
		}
		return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays + ","
				+ startTime + "," + endTime;
	}

}
