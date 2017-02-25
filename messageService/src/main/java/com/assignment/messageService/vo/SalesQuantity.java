package com.assignment.messageService.vo;

import com.assignment.messageService.processor.MessageProcessor;

public class SalesQuantity implements SalesMessage {
	
	private Sales sales;
	private int quantity;
	
	
	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void process(MessageProcessor processor) {
		processor.process(this);
	}

	
}
