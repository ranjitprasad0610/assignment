package com.assignment.messageservice.request.message;

import com.assignment.messageservice.messageprocessor.IMessageProcessor;


public final class Sales implements SalesMessage {
	
	private final String productType;
	private final int amount;
	
	public Sales(String productType, int amount) {
		super();
		this.productType = productType;
		this.amount = amount;
	}

	public String getProductType() {
		return productType;
	}

	public int getAmount() {
		return amount;
	}

	public void executeMessage(IMessageProcessor messageProcessor) {
		messageProcessor.processMessage(this);
		
	}

	@Override
	public String toString() {
		return "Sales [productType=" + getProductType() + ", amount=" + getAmount() + "]";
	}

	
}
