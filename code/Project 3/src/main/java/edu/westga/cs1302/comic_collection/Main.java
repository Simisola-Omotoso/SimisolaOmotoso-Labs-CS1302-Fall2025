package edu.westga.cs1302.comic_collection;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Main extends the JavaFX Application class to build the GUI and
 * start program execution.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Main extends Application {

	private static final String WINDOW_TITLE = "Comic Collection";
	private static final String MAIN_WINDOW_FXML = "/edu/westga/cs1302/comic_collection/view/MainWindow.fxml";
	private static final String COMIC_WINDOW_FXML = "/edu/westga/cs1302/comic_collection/view/ComicWindow.fxml";

	/** JavaFX Launch process
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage reference for the initial window of the application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader1 = new FXMLLoader();
		FXMLLoader loader2 = new FXMLLoader();
		
		loader1.setLocation(getClass().getResource(MAIN_WINDOW_FXML));
		loader2.setLocation(getClass().getResource(COMIC_WINDOW_FXML));
		
		Pane mainView = (Pane) loader1.load();
		Pane comicView = (Pane) loader2.load();
		
		HBox box = new HBox(10);
		box.getChildren().addAll(mainView, comicView);
		return box;
	}

	/**
	 * Launches the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
