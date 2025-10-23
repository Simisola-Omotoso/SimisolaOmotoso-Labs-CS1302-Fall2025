package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testCompare() {
		Task task1 = new Task("Submit Lab 6", "Turn in lab 6 by due date.", TaskPriority.HIGH);
		Task task2 = new Task("Work on Project 2", "Complete tasks associated with Project 2.", TaskPriority.MEDIUM);
		Ascending ascending = new Ascending();
		assertEquals(1, ascending.compare(task1, task2));
	}

}
