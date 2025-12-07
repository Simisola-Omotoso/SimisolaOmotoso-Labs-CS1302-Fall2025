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

	private StringProperty nameProperty;
	private ListProperty<Collection> collectionsProperty;
	private ObjectProperty<Collection> selectedCollectionProperty;
	
	public CollectionViewModel() {
		this.nameProperty = new SimpleStringProperty("");
		this.collectionsProperty = new SimpleListProperty<Collection>(FXCollections.observableArrayList(new ArrayList<Collection>()));
		this.selectedCollectionProperty = new SimpleObjectProperty<Collection>();
	}
	
	public StringProperty getNameProperty() {
		return this.nameProperty;
	}
	
	public ListProperty<Collection> getCollectionsProperty() {
		return this.collectionsProperty;
	}
	
	public ObjectProperty<Collection> getSelectedCollectionProperty() {
		return this.selectedCollectionProperty;
	}
	
	public void addCollection() {
		Collection collection = new Collection("Comics", 3, "Action");
		this.collectionsProperty.add(collection);
	}
	
	public void removeCollection() {
		Collection collection = this.selectedCollectionProperty.get();
		this.collectionsProperty.remove(collection);
	}
}
