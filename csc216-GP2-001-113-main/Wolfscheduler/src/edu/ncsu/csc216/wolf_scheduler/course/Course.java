package edu.ncsu.csc216.wolf_scheduler.course;


/**
 * Course is a holder for course information. It can hold, return, and set the course name, title,
 * section, credit hours, the instructor's unity id, meeting days, and the starting and end time.
 * Includes methods to check if other Course objects are equivalent. Subclass to Activity class.
 * @author Kenny Howard
 */
public class Course extends Activity {
	/** Minimum Course name length. */
	private static final int MIN_NAME_LENGTH = 5;
	/** Maximum Course name length. */
	private static final int MAX_NAME_LENGTH = 8;
	/** Minimum Course letter length that represents the subject, i.e. CSC of CSC 216. */
	private static final int MIN_LETTER_COUNT = 1;
	/** Maximum Course letter length that represents the subject, i.e. CSC of CSC 216. */
	private static final int MAX_LETTER_COUNT = 4;
	/** Digit length that represents the course number, i.e. 216 of CSC 216. */
	private static final int DIGIT_COUNT = 3;
	/** Section length that represents the section number, i.e. section 001 of CSC 216. */
	private static final int SECTION_LENGTH = 3;
	/** Maximum credit hours a course can be worth. */
	private static final int MAX_CREDITS = 5;
	/** Minimum credit hours a course can be worth. */
	private static final int MIN_CREDITS = 1;
	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/**
	 * Constructs the object Course with parameters for all fields
	 * and sets them with the appropriate setters.
	 * @param name Course name
	 * @param title Course title
	 * @param section Course section
	 * @param credits Course credit hours
	 * @param instructorId Unity ID of the instructor
	 * @param meetingDays Days when the class meets
	 * @param startTime Time when the class starts
	 * @param endTime Time when the class ends
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		super(title, meetingDays, startTime, endTime);
		setName(name);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	}
	/**
	 * Constructs the object Course with parameters for the course name, title, section,
	 * credit hours, instructor id, and meeting days and sets them using the constructor
	 * with eight parameters.
	 * @param name Course name
	 * @param title Course title
	 * @param section Course section
	 * @param credits Course credit hours
	 * @param instructorId Unity ID of the instructor
	 * @param meetingDays Days when the class meets
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}
	/**
	 * Returns the name of Course.
	 * @return the name of the Course
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the Course. Checks multiple times to see if the name is invalid, whether 
	 * by it being null, being too long or too short in length, not having a space between the
	 * letter and number parts of the name, and if the letters and numbers are too long or
	 * too short.
	 * @param name the name to set
	 * @throws IllegalArgumentException if name is null or not within proper parameters
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
				}
				else if (name.charAt(i) == ' ') {
					spaceFound = true;
				}
				else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			}
			else if (spaceFound) {
				if (Character.isDigit(name.charAt(i))) {
					digitCount++;
				}
				else {
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
	 * Returns the section number of Course.
	 * @return the section of the Course
	 */
	public String getSection() {
		return section;
	}
	/**
	 * Sets the section number of Course.
	 * @param section the section to set
	 * @throws IllegalArgumentException if the section is null or doesn't have 3 digits
	 */
	public void setSection(String section) {
		if (section == null || section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException("Invalid section.");
		}
		for (int i = 0; i < SECTION_LENGTH; i++) {
			if (Character.isDigit(section.charAt(i)) ) {
				continue;
			}
			else {
				throw new IllegalArgumentException("Invalid section.");
			}
		}
		this.section = section;
	}
	/**
	 * Returns the credit hours of Course.
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * Sets the credit hours of Course.
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
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	/**
	 * Sets the instructor's unity ID of Course.
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
	 * Checks if the meetingDays string has wrong letters or has too many of one letter.
	 * Called by Course's setMeetingDaysAndTime() method override.
	 * @param meetingDays string that holds what days of the week 
	 * @throws IllegalArgumentException if there's a duplicate letter or a non-weekday letter
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
	 * Overrides Activity's setMeetingDaysAndTime method to call dayCheck to check for
	 * acceptable characters in meetingDays, then calls the parent method.
	 * @param meetingDays days of the week when the course meets
	 * @param startTime time when the course starts
	 * @param endTime time when the course ends
	 * @throws IllegalArgumentException if the meetingDays is arranged and either start
	 *         or end time is not equal to 0
	 */
	@Override
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if ("A".equals(meetingDays)) { // "A" for Arranged
			if (startTime != 0 || endTime != 0) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}
			super.setMeetingDaysAndTime(meetingDays, 0, 0);
		}
		else {
			dayCheck(meetingDays); // Checks if meetingDays is valid
			super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
		}
	}
	/**
	 * Returns a comma separated value String of all Course fields. 
	 * Overrides default toString method.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
	    if ("A".equals(getMeetingDays())) {
	        return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays();
	    }
	    return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," +
	           getMeetingDays() + "," + getStartTime() + "," + getEndTime(); 
	}
	
	/**
	 * Using all fields in Course, creates a hashCode for Course. Overrides default method.
	 * @return hashCode integer a hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}
	
	/**
	 * Compares Course to a parameter Object by comparing all fields. Overrides default method.
	 * @param obj the Object being compared
	 * @return boolean true if obj is equivalent to Course on all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
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
		return true;
	}
	/**
	 * Sets and returns a String array containing name, section, title and meeting string.
	 * Overrides Activity's blank method.
	 * @return a 4 length String array holding name, section, title and meeting string
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] array = {name, section, getTitle(), getMeetingString()};
		return array;
	}
	
	/**
	 * Returns a string array containing name, section, title, credits, instructor id,
	 * meeting string and an empty string. Overrides Activity's blank method.
	 * @return a 7 length String array holding name, section, title, credits, instructor id,
	 *         meeting string and an empty string.
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] array = {name, section, getTitle(), "" + credits, instructorId, getMeetingString(), ""};
		return array;
	}
	
	/**
	 * Overrides Activity's isDuplicate method, casts the parameter Activity into a Course,
	 * and compares its name string with this Course. Returns true if both are the same,
	 * returns false otherwise.
	 * @param activity an Activity object to compare if it is a Course duplicate
	 * @return true/false value if Course and the parameter have the same name string
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		if (!(activity instanceof Course)) {
			return false;
		}
		Course dupli = (Course) activity;
		return this.name.equals(dupli.name);
	}


}
