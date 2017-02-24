package com.jpmc.assignment.model;

import java.util.List;

import com.jpmc.assignment.enums.ProductType;

public class SalesReport {
	
	private ProductType productType;
	private int numOfSales;
	private long amount;
	private List<AdjustmentDetails> adjustmentDetails;
	 
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public int getNumOfSales() {
		return numOfSales;
	}
	public void setNumOfSales(int numOfSales) {
		this.numOfSales = numOfSales;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public List<AdjustmentDetails> getAdjustmentDetails() {
		return adjustmentDetails;
	}
	public void setAdjustmentDetails(List<AdjustmentDetails> adjustmentDetails) {
		this.adjustmentDetails = adjustmentDetails;
	}
}
