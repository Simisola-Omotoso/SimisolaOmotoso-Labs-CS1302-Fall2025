package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	@FXML
	private TextField taskNameField;
	
	@FXML
	private TextArea taskDescriptionArea;
	
	@FXML
	private ComboBox priorityDropdown;
	
	@FXML
	private Button submit;
	
	@FXML
	private ListView taskList;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
