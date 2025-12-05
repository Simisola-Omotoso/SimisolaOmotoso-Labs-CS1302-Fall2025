package edu.westga.cs1302.comic_collection.view;

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
    @FXML private Button addCollection;
    @FXML private ListView collections;
    @FXML private Button removeCollection;
    @FXML private AnchorPane guiPane;
    @FXML private TextField name;
    
    @FXML
    void initialize() {
        
    }
}

