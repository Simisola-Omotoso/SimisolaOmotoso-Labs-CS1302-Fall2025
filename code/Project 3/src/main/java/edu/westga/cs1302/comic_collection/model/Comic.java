package edu.westga.cs1302.comic_collection.model;

public class Comic {

	private String name;
	
	private int issueNumber;
	
	private String genre;
	
	public Comic(String name, int issueNumber, String genre) {
		this.name = name;
		this.issueNumber = issueNumber;
		this.genre = genre;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIssueNumber() {
		return issueNumber;
	}
	
	public String getGenre() {
		return genre;
	}
}
