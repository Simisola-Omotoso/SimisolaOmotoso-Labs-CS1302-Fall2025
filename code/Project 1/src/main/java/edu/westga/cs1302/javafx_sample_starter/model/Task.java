package edu.westga.cs1302.javafx_sample_starter.model;

public class Task {
	
	private final String name;
	private String description;
	private final String priority;
	
	public Task (String name, String description, String priority) {
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getPriority() {
		return this.priority;
	}
	
	public String toString() {
		return getName();
	}
	
	public void updateDescription(String newDescription) {
		this.description = newDescription;
	}
}
