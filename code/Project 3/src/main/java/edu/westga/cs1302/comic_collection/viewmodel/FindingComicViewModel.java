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
	private Map<String, Comic> nameMap = new HashMap<>();
	private Map<String, Comic> issueMap = new HashMap<>();
	
	public FindingComicViewModel() {
		this.findingComicNameProperty = new SimpleStringProperty("");
		this.findingComicIssueNumberProperty = new SimpleStringProperty("");
		this.findingComics = new SimpleListProperty<Comic>(FXCollections.observableArrayList(new ArrayList<Comic>()));
		this.nameMap = nameMap;
		this.issueMap = issueMap;
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
	
	public void put() {
		String key1 = new String();
		String key2 = new String();
		Comic comic = new Comic(key1, key2);
		this.nameMap.put(key1, comic);
		this.issueMap.put(key2, comic);
	}
	
	public Comic findComic() {
		String titleValue = new String();
		String issueValue = new String();
		if (titleValue != null && !titleValue.isEmpty()) {
			Comic comic = this.nameMap.get(titleValue);
			if (comic != null) {
				return comic;
			}
		}
		if (issueValue != null && !issueValue.isEmpty()) {
			Comic comic = this.nameMap.get(issueValue);
			if (comic != null) {
				return comic;
			}
		}
		return null;
	}
}
