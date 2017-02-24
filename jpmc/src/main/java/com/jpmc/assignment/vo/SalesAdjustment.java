package com.jpmc.assignment.vo;

public class SalesAdjustment extends Sales {
	
	private String productType;
	private int value;
	private String adjustmentOperation;
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getAdjustmentOperation() {
		return adjustmentOperation;
	}
	public void setAdjustmentOperation(String adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}
}
