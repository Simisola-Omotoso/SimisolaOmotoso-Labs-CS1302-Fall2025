package edu.westga.cs1302.javafx_sample_starter.model.views;
import edu.westga.cs1302.javafx_sample_starter.model.Task;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	private ComboBox<String> priorityDropdown;
	
	@FXML
	private Button submit;
	
	@FXML
	private ListView<Task> taskList;
	
	private ObservableList<Task> tasks;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	tasks = FXCollections.observableArrayList();
    	taskList.setItems(tasks);
    	
    	priorityDropdown.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
    	priorityDropdown.setValue("Low");
    }
    
    @FXML
    protected void addTask() {
		Task newTask = new Task(taskNameField.toString(), taskDescriptionArea.toString(), priorityDropdown.toString());
		tasks.add(newTask);
	}
}
