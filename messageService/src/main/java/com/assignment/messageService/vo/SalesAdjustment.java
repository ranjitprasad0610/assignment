package com.assignment.messageService.vo;

import com.assignment.messageService.processor.MessageProcessor;

public class SalesAdjustment implements SalesMessage {
	
	private Sales sales;
	private String adjustmentOperation;
	
	public String getAdjustmentOperation() {
		return adjustmentOperation;
	}
	public void setAdjustmentOperation(String adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
	public void process(MessageProcessor processor) {
		processor.process(this);
		
	}
}
