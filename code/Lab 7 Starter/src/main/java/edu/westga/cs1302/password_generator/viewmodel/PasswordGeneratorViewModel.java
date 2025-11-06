package edu.westga.cs1302.password_generator.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Sets PasswordGenerator properties.
 * 
 * @author CS 1302
 * @version Fall 2024
 */

public class PasswordGeneratorViewModel {
	
	private IntegerProperty minimumLengthProperty;
	private BooleanProperty atLeastOneDigitProperty;
	private BooleanProperty oneUppercaseLetterProperty;
	private BooleanProperty oneLowercaseLetterProperty;
	private IntegerProperty randomNumberProperty;
	private StringProperty generatedPasswordProperty;
	
	private PasswordGenerator generator;
	
	/**
	 * Creates new ViewModel for PasswordGenerator.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public PasswordGeneratorViewModel() {
		this.minimumLengthProperty = new SimpleIntegerProperty();
		this.atLeastOneDigitProperty = new SimpleBooleanProperty();
		this.oneUppercaseLetterProperty = new SimpleBooleanProperty();
		this.oneLowercaseLetterProperty = new SimpleBooleanProperty();
		this.randomNumberProperty = new SimpleIntegerProperty();
		this.generatedPasswordProperty = new SimpleStringProperty();
		
		this.generator = new PasswordGenerator(System.currentTimeMillis());
	}
	
	/**
	 * Returns the minimum length property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minimum length property.
	 */
	
	public IntegerProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}
	
	/**
	 * Returns the one digit property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the one digit property.
	 */
	
	public BooleanProperty atLeastOneDigitProperty() {
		return this.atLeastOneDigitProperty;
	}
	
	/**
	 * Returns the upperrcase letter property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the uppercase letter property.
	 */
	
	public BooleanProperty oneUppercaseLetterProperty() {
		return this.oneUppercaseLetterProperty;
	}
	
	/**
	 * Returns the lowercase letter property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the lowercase letter property.
	 */
	
	public BooleanProperty oneLowercaseLetterProperty() {
		return this.oneLowercaseLetterProperty;
	}
	
	/**
	 * Returns the random number property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the random number property.
	 */
	
	public IntegerProperty randomNumberProperty() {
		return this.randomNumberProperty;
	}
	
	/**
	 * Returns the generated password property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the generated password property.
	 */
	
	public StringProperty generatedPasswordProperty() {
		return this.generatedPasswordProperty;
	}
	
	/**
	 * Generates password.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	
	public void generatePassword() {
    	this.generator.setMinimumLength(this.minimumLengthProperty.get());
    	this.generator.setMustHaveAtLeastOneDigit(this.atLeastOneDigitProperty.get());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.oneLowercaseLetterProperty.get());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.oneUppercaseLetterProperty.get());
    	
    	String password = this.generator.generatePassword();
    	
    	this.generatedPasswordProperty.set(password);
    }
}
