package edu.westga.cs1302.lab5.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.lab5.model.Student;

public abstract class Persistence {
	public abstract void saveStudentData(Student[] student) throws IllegalArgumentException, IOException;
	
	public abstract Student[] loadStudentData() throws FileNotFoundException, IOException;

	/** Save the students!.
		  * 
		  * @precondition students != null
			 * @postcondition none
			 * 
			 * @param students the set of students to save
			 * @param fileLocation location of file
			 * @throws IllegalArgumentException if precondition is violated
			 * @throws IOException Unable to write to FILE_LOCATION
			 */
	public void saveStudentData(Student[] students, String fileLocation) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		
	}
}
