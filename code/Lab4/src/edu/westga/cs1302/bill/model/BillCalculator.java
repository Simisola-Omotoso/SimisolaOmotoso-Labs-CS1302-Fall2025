package edu.westga.cs1302.bill.model;

public class BillCalculator {
	
	public static double calculateSubtotal(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("Items array can't be null.");
		}
		for (BillItem item : items) {
			if (item == null) {
				throw new IllegalArgumentException("Item can't be null.");
			}
		}
		double subtotal = 0.0;
		for (BillItem item : items) {
			subtotal += item.getAmount();
		}
		return subtotal;
	}

}
