package edu.westga.cs1302.password_generator.view;

import java.util.Random;

import javafx.util.converter.IntegerStringConverter;
import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    
    private PasswordGeneratorViewModel viewModel;

    @FXML
    void initialize() {
    	this.viewModel = new PasswordGeneratorViewModel();
        TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        this.minimumLength.setTextFormatter(formatter);
        this.viewModel.minimumLengthProperty().asObject().bindBidirectional(formatter.valueProperty());
        this.viewModel.atLeastOneDigitProperty().bindBidirectional(this.mustIncludeDigits.selectedProperty());
        this.viewModel.oneUppercaseLetterProperty().bindBidirectional(this.mustIncludeUpperCaseLetters.selectedProperty());
        this.viewModel.oneLowercaseLetterProperty().bindBidirectional(this.mustIncludeLowerCaseLetters.selectedProperty());

        this.output.textProperty().bind(this.viewModel.generatedPasswordProperty());;
    }
}
