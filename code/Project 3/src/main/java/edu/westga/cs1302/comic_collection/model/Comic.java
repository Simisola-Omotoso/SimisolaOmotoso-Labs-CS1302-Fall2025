package edu.westga.cs1302.comic_collection.model;

public class Comic {

	private String name;
	
	private String issueNumber;
	
	
	public Comic(String name, String issueNumber) {
		this.name = name;
		this.issueNumber = issueNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIssueNumber() {
		return issueNumber;
	}
}
