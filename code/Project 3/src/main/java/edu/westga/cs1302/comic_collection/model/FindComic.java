package edu.westga.cs1302.comic_collection.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FindComic {

	private String name;
	
	private int issueNumber;
	
	private ObservableList<Comic> comics;
	
	public FindComic(String name, int issueNumber) {
		this.name = name;
		this.issueNumber = issueNumber;
		this.comics = FXCollections.observableArrayList();
	}
	
	public String getName() {
		return name;
	}
	
	public int getIssueNumber() {
		return issueNumber;
	}
	
	public ObservableList<Comic> getComics() {
		return comics;
	}
	
	public Comic findComicByName(String newName) {
		for (Comic comic : comics) {
			if (comic.getName().equals(newName)) {
				return comic;
			}
		}
		return null;
	}
	
	public Comic findComicByNumber(int newNumber) {
		for (Comic comic : comics) {
			if (comic.getIssueNumber() == newNumber) {
				return comic;
			}
		}
		return null;
	}
}
