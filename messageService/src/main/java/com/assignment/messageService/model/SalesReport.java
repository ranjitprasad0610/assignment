package com.assignment.messageService.model;

import java.util.List;

public class SalesReport {
	
	private String productType;
	private int numOfSales;
	private int amount;
	private List<AdjustmentDetails> adjustmentDetails;
	 
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getNumOfSales() {
		return numOfSales;
	}
	public void setNumOfSales(int numOfSales) {
		this.numOfSales = numOfSales;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public List<AdjustmentDetails> getAdjustmentDetails() {
		return adjustmentDetails;
	}
	public void setAdjustmentDetails(List<AdjustmentDetails> adjustmentDetails) {
		this.adjustmentDetails = adjustmentDetails;
	}
}
