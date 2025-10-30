package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/** Stores subtasks
 * 
 * @author CS 1302
 * @version Fall 2025
 */

public class ContainerTask extends Task {
	private List<Task> subTasks;
	
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		this.subTasks = new ArrayList<>();
	}
	
	@Override
	public List<Task> getSubTasks() {
		return this.subTasks;
	}
	
	@Override
	public ContainerTask addTask(Task task) {
		this.subTasks.add(task);
		return this;
	}
	
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}
