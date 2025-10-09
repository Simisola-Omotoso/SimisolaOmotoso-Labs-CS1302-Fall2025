package edu.westga.cs1302.lab5.persistence;

import edu.westga.cs1302.lab5.model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Supports saving and loading student data.
 *
 * @author CS 1302
 * 
 * @version Fall 2025
 */
public class StudentDataPersistenceManager extends Persistence {

  public static final String FILE_LOCATION = "data.txt";
 
	
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
	@Override
	public void saveStudentData(Student[] students, String fileLocation) throws IllegalArgumentException, IOException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION)) {
			for (Student currStudent : students) {
				if (currStudent != null) {
					writer.write(currStudent.getName() + "," + currStudent.getGrade() + System.lineSeparator());
				}
			}
		}
	}
	
	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	
	@Override
	public Student[] loadStudentData() throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(StudentDataPersistenceManager.FILE_LOCATION);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] values = line.split(",");
				String name = values[0].trim();
				if (values.length != 2) {
					throw new IOException("Invalid CSV format");
				}
				int grade = Integer.parseInt(values[1].trim());
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
	
}
