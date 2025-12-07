package edu.westga.cs1302.comic_collection.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ComicWindow {

	@FXML private TextField comicName;
	@FXML private TextField issueNumber;
	@FXML private Button confirmComic;
	@FXML private Button cancelComic;
	@FXML private AnchorPane anchorPane;
	
	@FXML
	void initialize() {
		
	}
}
