package com.assignment.messageService.vo;

import com.assignment.messageService.processor.MessageProcessor;

public class Sales implements SalesMessage {
	
	private String productType;
	private int value;
	
	public Sales(String productType, int value) {
		super();
		this.productType = productType;
		this.value = value;
	}
	public String getProductType() {
		return productType;
	}
	
	public int getValue() {
		return value;
	}
	
	public void process(MessageProcessor processor) {
		processor.process(this);
		
	}
	
	
}
