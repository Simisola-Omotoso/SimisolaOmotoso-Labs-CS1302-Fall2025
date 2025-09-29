package edu.westga.cs1302.project_1.model.views;

import java.util.List;
import edu.westga.cs1302.project_1.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	
	@FXML
	private TextArea displayedDescription;
	
	@FXML
	private TextField displayedPriority;
	
	@FXML
	private Button update;
	
	@FXML
	private Button remove;
	
	@FXML
	private Label highTaskNumLabel;
	
	@FXML
	private Label mediumTaskNumLabel;
	
	@FXML
	private Label lowTaskNumLabel;
	
	@FXML
	private Button highTaskNumCounter;
	
	@FXML
	private Button mediumTaskNumCounter;
	
	@FXML
	private Button lowTaskNumCounter;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	try {
    		this.tasks = FXCollections.observableArrayList();
        	this.taskList.setItems(this.tasks);
        	
        	this.priorityDropdown.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
        	this.priorityDropdown.setValue("Low");
        	
        	this.taskList.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> this.displayTask(newSelection));
    	} catch (Exception error) {
    		System.err.println("Initialization failed: " + error.getMessage());
    	}
    	
    }
    
    @FXML
    protected void addTask() {
    	String name = this.taskNameField.getText();
    	String description = this.taskDescriptionArea.getText();
    	String priority = this.priorityDropdown.getValue();
    	
    	if (name == null || name.trim().isEmpty()) {
    		System.err.println("Task name is needed.");
    	}
    	try {
    		Task newTask = new Task(name, description, priority);
    		this.tasks.add(newTask);
    	} catch (IllegalArgumentException error) {
    		System.err.println("Invalid task: " + error.getMessage());
    	}
	}
    
    @FXML
    protected void displayTask(Task task) {
    	if (task != null) {
    		this.displayedDescription.setText(task.getDescription());
    		this.displayedPriority.setText(task.getPriority());
    	} else {
    		this.displayedDescription.clear();
    		this.displayedPriority.clear();
    	}
    }
    
    @FXML
    protected void updateDescriptionTask() {
    	try {
    		Task selectedTask = this.taskList.getSelectionModel().getSelectedItem();
        	String newDescription = this.displayedDescription.getText();
        	selectedTask.updateDescription(newDescription);
        	this.taskList.refresh();
    	} catch (Exception error) {
    		System.err.println("Failed to update task: " + error.getMessage());
    	}
    }
    
    @FXML
    protected void removeTask() {
    	try {
    		Task selectedTask = this.taskList.getSelectionModel().getSelectedItem();
        	this.tasks.remove(selectedTask);
    	} catch (Exception error) {
    		System.err.println("Failed to remove task: " + error.getMessage());
    	}
    }
    
    /**
     * Returns number of tasks for each priority
     * 
     * @param priority priority of task
     * @param taskList list of tasks
     * @return number of tasks for specified priority
     */
    
    public static int returnNumOfTask(String priority, List<Task> taskList) {
    	try {
    		int count = 0;
        	for (Task task : taskList) {
        		if (task.getPriority().equals(priority)) {
        			count++;
        		}
        	}
        	return count;
    	} catch (Exception error) {
    		System.err.println("Failed to count: " + error.getMessage());
    		return 0;
    	}
    }
    
    @FXML
    protected void displayNumOfTasks() {
    	try {
    		int numOfLowTasks = MainWindow.returnNumOfTask("Low", this.tasks);
        	int numOfMediumTasks = MainWindow.returnNumOfTask("Medium", this.tasks);
        	int numOfHighTasks = MainWindow.returnNumOfTask("High", this.tasks);
        	
        	this.highTaskNumCounter.setText("" + numOfHighTasks + "");
        	this.mediumTaskNumCounter.setText("" + numOfMediumTasks + "");
        	this.lowTaskNumCounter.setText("" + numOfLowTasks + "");
    	} catch (Exception error) {
    		System.err.println("Failed to display: " + error.getMessage());
    	}
    }
}
