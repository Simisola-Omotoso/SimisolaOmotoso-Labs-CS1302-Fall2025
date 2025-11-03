package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestAddTask {
	
	@Test
	void testTaskNull() {
		Task task = new Task("Make Bed", "Make your bed.", TaskPriority.LOW);
		assertThrows(IllegalArgumentException.class, ()-> {
			task.addTask(null);
		});
	}
	
	@Test
	void testTaskNormal() {
		Task task = new Task("Morning Routine", "Complete set of tasks before workday.", TaskPriority.MEDIUM);
		Task task2 = new Task("Make Bed", "Make your bed.", TaskPriority.LOW);
		ContainerTask newTask = task.addTask(task2);
		assertNotNull(newTask);
		assertEquals("Make Bed", newTask.getName());
		assertEquals("Make your bed.", newTask.getDescription());
		assertEquals(TaskPriority.LOW, newTask.getPriority());
	}
}
