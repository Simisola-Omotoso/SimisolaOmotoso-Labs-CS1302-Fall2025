package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FindingComicViewModel {

	private StringProperty findingComicNameProperty;
	private StringProperty findingComicIssueNumberProperty;
	private ListProperty<Comic> findingComics;
	private ObservableList<Comic> source;
	
	public FindingComicViewModel() {
		this.findingComicNameProperty = new SimpleStringProperty("");
		this.findingComicIssueNumberProperty = new SimpleStringProperty("");
		this.findingComics = new SimpleListProperty<Comic>(FXCollections.observableArrayList(new ArrayList<Comic>()));
		this.source = source;
	}
	
	public StringProperty getFindingComicNameProperty() {
		return this.findingComicNameProperty;
	}
	
	public StringProperty getFindingComicIssueNumberProperty() {
		return this.findingComicIssueNumberProperty;
	}
	
	public ListProperty<Comic> getFindingComics() {
		return this.findingComics;
	}
	
	public void findComicByTitle() {
		String name = this.findingComicNameProperty.get();
		String issue = this.findingComicIssueNumberProperty.get();
		Map<String, Comic> map = new HashMap<>();
		for (Comic comic : this.source) {
			String key = comic.getName().toLowerCase() + "-" + comic.getIssueNumber();
			map.put(key, comic);
		}
		
		String searchKey = name.toLowerCase() + "-" + issue;
		Comic result = map.get(searchKey);
		this.findingComics.clear();
		if (result != null) {
			this.findingComics.add(result);
		}
	}
}
