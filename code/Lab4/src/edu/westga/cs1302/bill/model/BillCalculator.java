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
	
	public static double calculateTax(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("Items array can't be null.");
		}
		for (BillItem item : items) {
			if (item == null) {
				throw new IllegalArgumentException("Item can't be null.");
			}
		}
		double totalTax = 0.0;
		for (BillItem item : items) {
			totalTax += item.getAmount() * 0.1;
		}
		return totalTax;
	}
	
	public static double calculateTip(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("Items array can't be null.");
		}
		for (BillItem item : items) {
			if (item == null) {
				throw new IllegalArgumentException("Item can't be null.");
			}
		}
		double totalTip = 0.0;
		for (BillItem item : items) {
			totalTip += item.getAmount() * 0.2;
		}
		return totalTip;
	}
	
	public static double calculateTotal(BillItem[] items) {
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
		double totalTax = 0.0;
		for (BillItem item : items) {
			totalTax += item.getAmount() * 0.1;
		}
		double totalTip = 0.0;
		for (BillItem item : items) {
			totalTip += item.getAmount() * 0.2;
		}
		return subtotal + totalTax + totalTip;
	}

}
