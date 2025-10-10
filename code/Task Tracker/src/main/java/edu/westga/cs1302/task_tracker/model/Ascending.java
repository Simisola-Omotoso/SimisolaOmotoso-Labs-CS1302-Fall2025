package edu.westga.cs1302.task_tracker.model;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/** Compares tasks in ascending order
 * 
 * @author Simisola Omotoso
 * @version 1.0
 */

public class Ascending {
	
	/** Compares two tasks and returns corresponding integer
	 * 
	 * @param task1 first task
	 * @param task2 second task
	 * @return value that is associated with a certain case
	 */
	
	public int compare(Task task1, Task task2) {
		if (task1.getPriority() == TaskPriority.LOW && task2.getPriority() == TaskPriority.MEDIUM) {
			return -1;
		} else if (task1.getPriority() == TaskPriority.MEDIUM && task2.getPriority() == TaskPriority.HIGH) {
			return -1;
		} else if (task1.getPriority() == TaskPriority.MEDIUM && task2.getPriority() == TaskPriority.MEDIUM) {
			return 0;
		} else if (task1.getPriority() == TaskPriority.HIGH && task2.getPriority() == TaskPriority.HIGH) {
			return 0;
		} else if (task1.getPriority() == TaskPriority.LOW && task2.getPriority() == TaskPriority.LOW) {
			return -1;
		}
		return 1;
	}
}
