package com.assignment.messageservice.request.message;

import com.assignment.messageservice.messageprocessor.IMessageProcessor;


public final class SalesAdjustmentMessage implements SalesMessage {

	private final Sales sales;
	private final String adjustment;

	public SalesAdjustmentMessage(Sales sales, String adjustment) {
		super();
		this.sales = sales;
		this.adjustment = adjustment;
	}

	public Sales getSales() {
		return sales;
	}

	public String getAdjustment() {
		return adjustment;
	}

	public void executeMessage(IMessageProcessor messageProcessor) {
		messageProcessor.processMessage(this);
	}

	@Override
	public String toString() {
		return "SalesAdjustmentMessage [sales=" + getSales() + ", adjustment="
				+ getAdjustment() + "]";
	}

}
