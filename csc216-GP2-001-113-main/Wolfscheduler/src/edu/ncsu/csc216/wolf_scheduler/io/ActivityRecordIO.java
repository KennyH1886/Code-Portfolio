package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;
/**
 * ActivityRecordIO is a small class and has only one method.
 * writeActivityRecords writes records of Activities to a given file.
 * If a file is unable to be written to, it throws an IOException.
 * @author Kenny Howard s
 */
public class ActivityRecordIO {

	/**
	 * Writes the given list of Activities to a file. Throws an
	 * IOException if file cannot be written to.
	 * @param fileName file to write schedule of Activities to
	 * @param activities list of Activities to write
	 * @throws IOException if it cannot write to file
	 */
	public static void writeActivityRecords(String fileName, ArrayList<Activity> activities) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
	
		for (int i = 0; i < activities.size(); i++) {
		    fileWriter.println(activities.get(i).toString());
		}
	
		fileWriter.close();
		
	}

}
