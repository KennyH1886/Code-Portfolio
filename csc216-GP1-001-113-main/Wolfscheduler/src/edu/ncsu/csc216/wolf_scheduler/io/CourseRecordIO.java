package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_scheduler.course.Course;

/**
 * Reads Course records from text files.  Writes a set of CourseRecords to a file.
 * One method reads through a textfile and returns an ArrayList of Courses, another reads through
 * lines from the file, and another makes a file out of a parametered Course ArrayList.
 * @author Kenny Howard
 */
public class CourseRecordIO {
	
	/**
     * Reads course records from a file and generates a list of valid Courses.  Any invalid
     * Courses are ignored.  If the file to read cannot be found or the permissions are incorrect
     * a File NotFoundException is thrown.
     * @param fileName file to read Course records from
     * @return a list of valid Courses
     * @throws FileNotFoundException if the file cannot be found or read
     */
	public static ArrayList<Course> readCourseRecords(String fileName) throws FileNotFoundException {
	    Scanner fileReader = new Scanner(new FileInputStream(fileName));  //Create a file scanner to read the file
	    ArrayList<Course> courses = new ArrayList<Course>(); //Create an empty array of Course objects
	    while (fileReader.hasNextLine()) { //While we have more lines in the file
	        try { //Attempt to do the following
	            //Read the line, process it in readCourse, and get the object
	            //If trying to construct a Course in readCourse() results in an exception, flow of control will transfer to the catch block, below
	            Course course = readCourse(fileReader.nextLine()); 

	            //Create a flag to see if the newly created Course is a duplicate of something already in the list  
	            boolean duplicate = false;
	            //Look at all the courses in our list
	            for (int i = 0; i < courses.size(); i++) {
	                //Get the course at index i
	                Course current = courses.get(i);
	                //Check if the name and section are the same
	                if (course.getName().equals(current.getName()) &&
	                        course.getSection().equals(current.getSection())) {
	                    //It's a duplicate!
	                    duplicate = true;
	                    break; //We can break out of the loop, no need to continue searching
	                }
	            }
	            //If the course is NOT a duplicate
	            if (!duplicate) {
	                courses.add(course); //Add to the ArrayList!
	            } //Otherwise ignore
	        } catch (IllegalArgumentException e) {
	            //The line is invalid b/c we couldn't create a course, skip it!
	        }
	    }
	    //Close the Scanner b/c we're responsible with our file handles
	    fileReader.close();
	    //Return the ArrayList with all the courses we read!
	    return courses;
	}
	/**
	 * Reads through a line string with course information, and creates a
	 * corresponding Course object, if applicable.
	 * @param nextLine string with information to construct Course object
	 * @return Course new constructed based on the nextLine string
	 * @throws IllegalArgumentException if invalid tokens are detected
	 */
	private static Course readCourse(String nextLine) {
		Scanner read = new Scanner(nextLine);
		read.useDelimiter(",");
		try {
			String name = read.next();
			String title = read.next();
			String section = read.next();
			int credits = read.nextInt();
			String instrId = read.next();
			String meetDay = read.next();
			if ("A".equals(meetDay)) {
				if (read.hasNext()) {
					read.close();
					throw new IllegalArgumentException("Invalid tokens.");
				}
				else {
					read.close();
					return new Course(name, title, section, credits, instrId, meetDay);
				}
			}
			else {
				int sTime = read.nextInt();
				int eTime = read.nextInt();
				if (read.hasNext()) {
					read.close();
					throw new IllegalArgumentException("Invalid tokens.");
				}
				read.close();
				return new Course(name, title, section, credits, instrId, meetDay, sTime, eTime);
			}
		} catch (Exception iae){
			throw new IllegalArgumentException("Invalid tokens.");
		}
	}
	/**
     * Writes the given list of Courses to a file. Throws an
     * IOException if file cannot be written to.
     * @param fileName file to write schedule of Courses to
     * @param courses list of Courses to write
     * @throws IOException if cannot write to file
     */
	public static void writeCourseRecords(String fileName, ArrayList<Course> courses) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));

		for (int i = 0; i < courses.size(); i++) {
		    fileWriter.println(courses.get(i).toString());
		}

		fileWriter.close();
		
	}

}
