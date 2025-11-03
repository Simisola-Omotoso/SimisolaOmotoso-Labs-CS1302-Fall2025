package edu.westga.cs1302.task_tracker.model.descendingbyname;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingByName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;


public class TestCompare {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingByName descending = new DescendingByName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingByName descending = new DescendingByName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
	}
	
	@Test
	void testO1AndO2SameName() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1NameO2Game() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("game", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1GameO2Name() {
		Task o1 = new Task("game", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
}
