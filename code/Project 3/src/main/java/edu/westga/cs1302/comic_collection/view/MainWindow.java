package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.viewmodel.CollectionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/** Codebehind for the MainWindow
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	@FXML private TextField name;
    @FXML private Button addCollection;
    @FXML private ListView<Collection> collections;
    @FXML private Button removeCollection;
    @FXML private AnchorPane guiPane;
    private CollectionViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new CollectionViewModel();
    	this.name.textProperty().bindBidirectional(this.vm.getNameProperty());
    	this.addCollection.setOnAction((event) -> {
    		this.vm.addCollection();
    	});
    	this.collections.setItems(this.vm.getCollectionsProperty());
    	this.removeCollection.setOnAction((event) -> {
    		this.vm.removeCollection();
    	});
    	this.vm.getSelectedCollectionProperty().bind(this.collections.getSelectionModel().selectedItemProperty());
    }
}

