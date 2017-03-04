package com.assignment.messageservice.response;

import java.util.ArrayList;
import java.util.List;

public class SalesDetail {
	
	private String productType;
	private int noOfSales;
	private int amount;
	List<Adjustment> adjustments;
	
	public SalesDetail() {
		adjustments = new ArrayList<Adjustment>();
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getNoOfSales() {
		return noOfSales;
	}

	public void setNoOfSales(int noOfSales) {
		this.noOfSales = noOfSales;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Adjustment> getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(List<Adjustment> adjustments) {
		this.adjustments = adjustments;
	}

	@Override
	public String toString() {
		return "SalesDetail [productType=" + productType + ", noOfSales="
				+ noOfSales + ", amount=" + amount + ", adjustments="
				+ adjustments + "]";
	}
	
}
