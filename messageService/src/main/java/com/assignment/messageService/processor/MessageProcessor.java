package com.assignment.messageService.processor;

import com.assignment.messageService.vo.Sales;
import com.assignment.messageService.vo.SalesAdjustment;
import com.assignment.messageService.vo.SalesQuantity;

public interface MessageProcessor {
	
	public abstract void process(Sales sale);
	
	public abstract void process(SalesQuantity salesQuantity);
	
	public abstract void process(SalesAdjustment salesAdjustment);

}
