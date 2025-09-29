package edu.westga.cs1302.project_1.model;

/**
 * Creates task
 * 
 * @author Simisola Omotoso
 * @version 1.0
 */

public class Task {
	
	private final String name;
	private String description;
	private final String priority;
	
	/**
	 * Initializes Task class
	 * 
	 * @param name name of task
	 * @param description what task is about
	 * @param priority how important task is
	 */
	
	public Task(String name, String description, String priority) {
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	/**
	 * Gets name
	 * @return this.name
	 */
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets description
	 * @return this.description
	 */
	
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets priority
	 * @return this.priority
	 */
	
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * Converts to string
	 * @return getName()
	 */
	
	public String toString() {
		return this.getName();
	}
	
	/**
	 * Updates description
	 * 
	 * @param newDescription new description that replaces former one
	 */
	
	public void updateDescription(String newDescription) {
		if (newDescription == null) {
			throw new NullPointerException("Description can't be null.");
		}
		if (newDescription.trim().isEmpty()) {
			throw new IllegalArgumentException("Description can't be empty.");
		}
		this.description = newDescription;
	}
}
