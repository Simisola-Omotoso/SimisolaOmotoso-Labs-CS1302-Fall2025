package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Collection {

	private String name;
	
	private int numOfComics;
	
	private String genre;
	
	private ObservableList<Comic> comics;
	
	public Collection(String name, int numOfComics, String genre) {
		this.name = name;
		this.numOfComics = numOfComics;
		this.genre = genre;
		this.comics = FXCollections.observableArrayList();
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
	
	public ObservableList<Comic> getComics() {
		return comics;
	}
}
