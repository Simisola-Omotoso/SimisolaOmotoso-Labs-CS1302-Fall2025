package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + BillCalculator.calculateSubtotal(bill.getItems().toArray(new BillItem[0])) + System.lineSeparator();
		text += "TAX - $" + BillView.roundToNearestHundredth(BillCalculator.calculateTax(bill.getItems().toArray(new BillItem[0]))) + System.lineSeparator();
		text += "TIP - $" + BillView.roundToNearestHundredth(BillCalculator.calculateTip(bill.getItems().toArray(new BillItem[0]))) + System.lineSeparator();
		text += "TOTAL - $" + BillView.roundToNearestHundredth(BillCalculator.calculateTotal(bill.getItems().toArray(new BillItem[0])));
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
