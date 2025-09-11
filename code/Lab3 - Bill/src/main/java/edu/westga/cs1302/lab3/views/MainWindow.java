package edu.westga.cs1302.lab3.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;


/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	@FXML private TextField name;
	@FXML private TextField amount;
	@FXML private Button button;
	@FXML private TextArea billDisplay;
	
	private Bill bill = new Bill();
	private BillView view = new BillView();
	
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	String name = this.name.getText();
    	String amount = this.amount.getText();
    	
    	if (name.isEmpty() || amount.isEmpty()) {
    		this.billDisplay.setText("Enter name & amount.");
    		return;
    	}
    	
    	try {
    		double amountValue = Double.parseDouble(amount);
        	BillItem item = new BillItem(name, amountValue);
        	bill.addItem(item);
        	String billView = view.getText(bill);
        	billDisplay.setText(billView);
    	} catch (NumberFormatException e) {
    		this.billDisplay.setText("Amount is an invalid value.");
    	}
    	
    }
}
