package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

import static org.junit.jupiter.api.Assertions.*;

public class TestCheckForInvalidMinimumLengthText {
	
	@Test
	void testValidInputOneDigit() {
		String newValue = "1";
		ViewModel viewModel = new ViewModel();
		assertEquals(false, viewModel.checkForInvalidMinimumLengthText(newValue));
	}
	
	@Test
	void testValidInputTwoDigits() {
		String newValue = "12";
		ViewModel viewModel = new ViewModel();
		assertEquals(false, viewModel.checkForInvalidMinimumLengthText(newValue));
	}
	
	@Test
	void testValidInputThreeDigits() {
		String newValue = "123";
		ViewModel viewModel = new ViewModel();
		assertEquals(false, viewModel.checkForInvalidMinimumLengthText(newValue));
	}
	
	@Test
	void testInvalidInputOneDigit() {
		String newValue = "0";
		ViewModel viewModel = new ViewModel();
		assertEquals(true, viewModel.checkForInvalidMinimumLengthText(newValue));
	}
	
	@Test
	void testInvalidInputTwoDigits() {
		String newValue = "01";
		ViewModel viewModel = new ViewModel();
		assertEquals(true, viewModel.checkForInvalidMinimumLengthText(newValue));
	}
}
