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
    	tasks = FXCollections.observableArrayList();
    	taskList.setItems(tasks);
    	
    	priorityDropdown.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
    	priorityDropdown.setValue("Low");
    	
    	taskList.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> displayTask(newSelection));
    }
    
    @FXML
    protected void addTask() {
    	String name = taskNameField.getText();
    	String description = taskDescriptionArea.getText();
    	String priority = priorityDropdown.getValue();
		Task newTask = new Task(name, description, priority);
		tasks.add(newTask);
	}
    
    @FXML
    protected void displayTask(Task task) {
    	if (task != null) {
    		displayedDescription.setText(task.getDescription());
    		displayedPriority.setText(task.getPriority());
    	} else {
    		displayedDescription.clear();
    		displayedPriority.clear();
    	}
    }
    
    @FXML
    protected void updateDescriptionTask() {
    	Task selectedTask = taskList.getSelectionModel().getSelectedItem();
    	String newDescription = displayedDescription.getText();
    	selectedTask.updateDescription(newDescription);
    	taskList.refresh();
    }
    
    @FXML
    protected void removeTask() {
    	Task selectedTask = taskList.getSelectionModel().getSelectedItem();
    	tasks.remove(selectedTask);
    }
    
    public static int returnNumOfTask(String priority, List<Task> taskList) {
    	int count = 0;
    	for (Task task : taskList) {
    		if (task.getPriority().equals(priority)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    @FXML
    protected void displayNumOfTasks() {
    	int numOfLowTasks = MainWindow.returnNumOfTask("Low", tasks);
    	int numOfMediumTasks = MainWindow.returnNumOfTask("Medium", tasks);
    	int numOfHighTasks = MainWindow.returnNumOfTask("High", tasks);
    	
    	highTaskNumCounter.setText("" + numOfHighTasks + "");
    	mediumTaskNumCounter.setText("" + numOfMediumTasks + "");
    	lowTaskNumCounter.setText("" + numOfLowTasks + "");
    }
}
