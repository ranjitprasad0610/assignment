package com.assignment.messageService.vo;

import java.util.Collections;
import java.util.List;

public final class Message {
	
	private final List<Sales> sales;
	
	public Message(final List<Sales> sales) {
		this.sales = Collections.unmodifiableList(sales);
	}

	public List<Sales> getSales() {
		return Collections.unmodifiableList(sales);
	}

	@Override
	public String toString() {
		return "SalesMessage [sales=" + sales + "]";
	}
	
	
}
