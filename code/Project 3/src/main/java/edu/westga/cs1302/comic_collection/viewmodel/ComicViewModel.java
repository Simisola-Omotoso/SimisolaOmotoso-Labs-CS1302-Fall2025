package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;
import java.util.Objects;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class ComicViewModel {

	private StringProperty comicNameProperty;
	private StringProperty issueNumberProperty;
	private ListProperty<Comic> comicListProperty;
	private ObjectProperty<Comic> selectedComicProperty;
	
	private CollectionViewModel collectionViewModel;
	
	public ComicViewModel(CollectionViewModel collectionViewModel) {
		this.comicNameProperty = new SimpleStringProperty("");
		this.issueNumberProperty = new SimpleStringProperty("");
		this.comicListProperty = new SimpleListProperty<Comic>(FXCollections.observableArrayList(new ArrayList<Comic>()));
		this.selectedComicProperty = new SimpleObjectProperty<Comic>();
		this.collectionViewModel = Objects.requireNonNull(collectionViewModel);
	}
	
	public StringProperty getComicNameProperty() {
		return comicNameProperty;
	}
	
	public StringProperty getIssueNumberProperty() {
		return issueNumberProperty;
	}
	
	public ListProperty<Comic> getComicListProperty() {
		return comicListProperty;
	}
	
	public ObjectProperty<Comic> selectedComicProperty() {
		return selectedComicProperty;
	}
	
	public void addComic() {
		Comic comic = new Comic("Batman Returns", "1");
		Collection collection = this.collectionViewModel.getSelectedCollectionProperty().get();
		collection.getComics().add(comic);
	}
	
	public void removeComic() {
		Collection collection = this.collectionViewModel.getSelectedCollectionProperty().get();
		Comic comic = this.selectedComicProperty.get();
		collection.getComics().remove(comic);
	}
}
