package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/** Stores subtasks
 * 
 * @author CS 1302
 * @version Fall 2025
 */

public class ContainerTask extends Task {
	private List<Task> subTasks;
	
	/** Create a new ContainerTask with the provided information.
	 * 
	 * @precondition name != null && !name.isEmpty() &&
	 * 				description != null &&
	 * 				priority != null
	 * 
	 * @param name the name of the task
	 * @param description the description of the task
	 * @param priority the priority of the task
	 */
	
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		if (description == null) {
			throw new IllegalArgumentException("description must not be null");
		}
		if (priority == null) {
			throw new IllegalArgumentException("priority must not be null");
		}
		this.subTasks = new ArrayList<>();
	}
	
	/** Returns subtasks
	 * 
	 * @return List of tasks
	 */
	@Override
	public List<Task> getSubTasks() {
		return this.subTasks;
	}
	
	/** Adds new task
	 * 
	 * @precondition task != null
	 * 
	 * @param task new task to be added
	 * @return new ContainerTask
	 */
	@Override
	public ContainerTask addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		this.subTasks.add(task);
		return this;
	}
	
	/** Returns the name of the task to represent the task as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task along with sign
	 */
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}
