package edu.westga.cs1302.comic_collection.view;

import java.io.IOException;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.viewmodel.CollectionViewModel;
import edu.westga.cs1302.comic_collection.viewmodel.ComicViewModel;
import edu.westga.cs1302.comic_collection.viewmodel.FindingComicViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Codebehind for the MainWindow
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	@FXML private TextField name;
    @FXML private Button addCollection;
    @FXML private Button addComic;
    @FXML private ListView<Collection> collections;
    @FXML private ListView<Comic> comics;
    @FXML private Button removeCollection;
    @FXML private Button removeComic;
    @FXML private TextField searchTitle;
    @FXML private TextField searchIssueNumber;
    @FXML private Button searchButton;
    @FXML private AnchorPane guiPane;
    private CollectionViewModel vm;
    private ComicViewModel comicVM;
    private FindingComicViewModel findingVM;
    
    @FXML
    void initialize() {
    	this.vm = new CollectionViewModel();
    	this.comicVM = new ComicViewModel(this.vm);
    	this.findingVM = new FindingComicViewModel();
    	this.name.textProperty().bindBidirectional(this.vm.getNameProperty());
    	this.addCollection.setOnAction((event) -> {
    		this.vm.addCollection();
    	});
    	this.addCollection.disableProperty().bind(this.vm.getNameProperty().isEmpty());
    	this.collections.setItems(this.vm.getCollectionsProperty());
    	this.removeCollection.setOnAction((event) -> {
    		this.vm.removeCollection();
    	});
    	this.vm.getSelectedCollectionProperty().bind(this.collections.getSelectionModel().selectedItemProperty());
    	this.vm.getSelectedCollectionProperty().addListener((observable, oldCollection, newCollection) -> {
    		if (newCollection != null) {
    			this.comics.setItems(newCollection.getComics());
    		} else {
    			this.comics.setItems(null);
    		}
    	});
    	this.comicVM.selectedComicProperty().bind(this.comics.getSelectionModel().selectedItemProperty());
    	this.removeComic.setOnAction((event) -> {
    		this.comicVM.removeComic();
    	});
    	this.addComic.setOnAction((event) -> {
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/cs1302/comic_collection/view/ComicWindow.fxml"));
    			ComicWindow controller = new ComicWindow(this.comicVM);
    			loader.setController(controller);
    			Parent root = loader.load();
    			Stage stage = new Stage();
    			stage.setScene(new Scene(root));
    			stage.showAndWait();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    	});
    	this.searchTitle.textProperty().bindBidirectional(this.findingVM.getFindingComicNameProperty());
    	this.searchIssueNumber.textProperty().bindBidirectional(this.findingVM.getFindingComicIssueNumberProperty());
    	this.searchButton.disableProperty().bind(this.searchTitle.textProperty().isEmpty().and(this.searchIssueNumber.textProperty().isEmpty()));
    	this.searchButton.setOnAction((event) -> {
    		Comic comic = this.findingVM.findComic();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Comic");
    		alert.setContentText(comic.getName() + " " + comic.getIssueNumber());
    		alert.showAndWait();
    	});
    }
}

