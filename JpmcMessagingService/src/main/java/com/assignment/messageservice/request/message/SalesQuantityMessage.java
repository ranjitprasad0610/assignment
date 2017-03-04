package com.assignment.messageservice.request.message;

import com.assignment.messageservice.messageprocessor.IMessageProcessor;


public final class SalesQuantityMessage implements SalesMessage {

	private final Sales sales;
	private final int quantity;

	public SalesQuantityMessage(Sales sales, int quantity) {
		super();
		this.sales = sales;
		this.quantity = quantity;
	}

	public Sales getSales() {
		return sales;
	}

	public int getQuantity() {
		return quantity;
	}

	public void executeMessage(IMessageProcessor messageProcessor) {
		messageProcessor.processMessage(this);
	}

	@Override
	public String toString() {
		return "SalesQuantityMessage [getSales()=" + getSales()
				+ ", getQuantity()=" + getQuantity() + "]";
	}

}
