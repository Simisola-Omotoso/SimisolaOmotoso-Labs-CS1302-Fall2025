package edu.westga.cs1302.password_generator.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.property.SimpleBooleanProperty;

public class PasswordGeneratorViewModel {
	
	private IntegerProperty minimumLengthProperty;
	private BooleanProperty atLeastOneDigitProperty;
	private BooleanProperty oneUppercaseLetterProperty;
	private BooleanProperty oneLowercaseLetterProperty;
	private IntegerProperty randomNumberProperty;
	private StringProperty generatedPasswordProperty;
	
	private PasswordGenerator generator;
	
	public PasswordGeneratorViewModel() {
		this.minimumLengthProperty = new SimpleIntegerProperty();
		this.atLeastOneDigitProperty = new SimpleBooleanProperty();
		this.oneUppercaseLetterProperty = new SimpleBooleanProperty();
		this.oneLowercaseLetterProperty = new SimpleBooleanProperty();
		this.randomNumberProperty = new SimpleIntegerProperty();
		this.generatedPasswordProperty = new SimpleStringProperty();
		
		this.generator = new PasswordGenerator(System.currentTimeMillis());
	}
	
	public IntegerProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}
	
	public BooleanProperty atLeastOneDigitProperty() {
		return this.atLeastOneDigitProperty;
	}
	
	public BooleanProperty oneUppercaseLetterProperty() {
		return this.oneUppercaseLetterProperty;
	}
	
	public BooleanProperty oneLowercaseLetterProperty() {
		return this.oneLowercaseLetterProperty;
	}
	
	public IntegerProperty randomNumberProperty() {
		return this.randomNumberProperty;
	}
	
	public StringProperty generatedPasswordProperty() {
		return this.generatedPasswordProperty;
	}
	
	public void generatePassword() {
    	this.generator.setMinimumLength(minimumLengthProperty.get());
    	this.generator.setMustHaveAtLeastOneDigit(atLeastOneDigitProperty.get());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(oneLowercaseLetterProperty.get());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(oneUppercaseLetterProperty.get());
    	
    	String password = this.generator.generatePassword();
    	
    	generatedPasswordProperty.set(password);
    }
}
