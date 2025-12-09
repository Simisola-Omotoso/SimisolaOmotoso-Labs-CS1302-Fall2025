package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.CollectionViewModel;
import edu.westga.cs1302.comic_collection.viewmodel.ComicViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ComicWindow {

	@FXML private TextField comicName;
	@FXML private TextField issueNumber;
	@FXML private Button confirmComic;
	@FXML private Button cancelComic;
	@FXML private AnchorPane anchorPane;
	private ComicViewModel comicVM;
	private CollectionViewModel vm;
	
	public ComicWindow(ComicViewModel comicVM) {
		this.comicVM = comicVM;
	}
	
	@FXML
	void initialize() {
		this.comicName.textProperty().bindBidirectional(this.comicVM.getComicNameProperty());
		this.issueNumber.textProperty().bindBidirectional(this.comicVM.getIssueNumberProperty());
		this.confirmComic.disableProperty().bind(this.comicVM.getComicNameProperty().isEmpty());
		this.confirmComic.disableProperty().bind(this.comicVM.getIssueNumberProperty().isEmpty());
		this.confirmComic.setOnAction((event) -> {
			this.comicVM.addComic();
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
		});
		this.cancelComic.setOnAction((event) -> {
			this.comicVM.removeComic();
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
		});
	}
}
