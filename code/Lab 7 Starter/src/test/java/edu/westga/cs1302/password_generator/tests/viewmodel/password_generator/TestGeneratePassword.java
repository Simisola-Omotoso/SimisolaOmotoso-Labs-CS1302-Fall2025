package edu.westga.cs1302.password_generator.tests.viewmodel.password_generator;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TestGeneratePassword {
	@Test
	void testMinimumLengthDefaultValue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		assertEquals(0, generator.minimumLengthProperty().get());
	}
	
	@Test
	void testMinimumLengthRandomValue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.minimumLengthProperty().set(20);
		assertEquals(20, generator.minimumLengthProperty().get());
	}
	
	@Test
	void testMinimumLengthBidirectional() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		IntegerProperty integerProperty = new SimpleIntegerProperty();
		
		generator.minimumLengthProperty().bindBidirectional(integerProperty);
		
		integerProperty.set(6);
		assertEquals(6, generator.minimumLengthProperty().get());
		
		generator.minimumLengthProperty().set(42);
		assertEquals(42, integerProperty.get());
	}
	
	@Test
	void testOneDigitDefaultValue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		assertEquals(false, generator.atLeastOneDigitProperty().get());
	}
	
	@Test
	void testOneDigitTrue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.atLeastOneDigitProperty().set(true);
		assertEquals(true, generator.atLeastOneDigitProperty().get());
	}
	
	@Test
	void testOneDigitBidirectional() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		BooleanProperty booleanProperty = new SimpleBooleanProperty();
		
		generator.atLeastOneDigitProperty().bindBidirectional(booleanProperty);
		
		booleanProperty.set(true);
		assertEquals(true, generator.atLeastOneDigitProperty().get());
		
		generator.atLeastOneDigitProperty().set(false);
		assertEquals(false, booleanProperty.get());
	}
	
	@Test
	void testOneLowercaseLetterDefaultValue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		assertEquals(false, generator.oneLowercaseLetterProperty().get());
	}
	
	@Test
	void testOneLowercaseLetterTrue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.oneLowercaseLetterProperty().set(true);
		assertEquals(true, generator.oneLowercaseLetterProperty().get());
	}
	
	@Test
	void testOneLowercaseLetterBidirectional() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		BooleanProperty booleanProperty = new SimpleBooleanProperty();
		
		generator.oneLowercaseLetterProperty().bindBidirectional(booleanProperty);
		
		booleanProperty.set(true);
		assertEquals(true, generator.oneLowercaseLetterProperty().get());
		
		generator.oneLowercaseLetterProperty().set(false);
		assertEquals(false, booleanProperty.get());
	}
	
	@Test
	void testOneUppercaseLetterDefaultValue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		assertEquals(false, generator.oneUppercaseLetterProperty().get());
	}
	
	@Test
	void testOneUppercaseLetterTrue() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		generator.oneUppercaseLetterProperty().set(true);
		assertEquals(true, generator.oneUppercaseLetterProperty().get());
	}
	
	@Test
	void testOneUppercaseLetterBidirectional() {
		PasswordGeneratorViewModel generator = new PasswordGeneratorViewModel();
		BooleanProperty booleanProperty = new SimpleBooleanProperty();
		
		generator.oneUppercaseLetterProperty().bindBidirectional(booleanProperty);
		
		booleanProperty.set(true);
		assertEquals(true, generator.oneUppercaseLetterProperty().get());
		
		generator.oneUppercaseLetterProperty().set(false);
		assertEquals(false, booleanProperty.get());
	}
}
