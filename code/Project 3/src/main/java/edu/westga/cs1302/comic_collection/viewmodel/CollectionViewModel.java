package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class CollectionViewModel {

	private StringProperty name;
	private ListProperty<Collection> collections;
	private ObjectProperty<Collection> selectedCollection;
	
	public CollectionViewModel() {
		this.name = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableArrayList(new ArrayList<Collection>()));
		this.selectedCollection = new SimpleObjectProperty<Collection>();
	}
	
	public StringProperty getName() {
		return name;
	}
	
	public ListProperty<Collection> getCollections() {
		return collections;
	}
	
	public ObjectProperty<Collection> getAddCollection() {
		return selectedCollection;
	}
	
	public void addCollection() {
		Collection collection = new Collection("Comics", 3, "Action");
		this.collections.add(collection);
	}
	
	public void removeCollection() {
		Collection collection = this.selectedCollection.get();
		this.collections.remove(collection);
	}
}
