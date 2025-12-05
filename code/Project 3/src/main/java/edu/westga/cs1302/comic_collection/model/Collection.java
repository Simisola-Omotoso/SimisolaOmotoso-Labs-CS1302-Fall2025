package edu.westga.cs1302.comic_collection.model;

public class Collection {

	private String name;
	
	private int numOfComics;
	
	private String genre;
	
	public Collection(String name, int numOfComics, String genre) {
		this.name = name;
		this.numOfComics = numOfComics;
		this.genre = genre;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumOfComics() {
		return numOfComics;
	}
	
	public String getGenre() {
		return genre;
	}
}
