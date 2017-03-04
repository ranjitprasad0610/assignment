package com.assignment.messageservice.messageprocessor;

import java.util.Map;

import com.assignment.messageservice.request.message.Sales;
import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.request.message.SalesQuantityMessage;
import com.assignment.messageservice.response.SalesDetail;

public interface IMessageProcessor {
	
	public void processMessage(Sales sales);
	
	public void processMessage(SalesAdjustmentMessage adjustmentMessage);
	
	public void processMessage(SalesQuantityMessage quantityMessage);
	
	public Map<String, SalesDetail> getSalesDetail();

}
