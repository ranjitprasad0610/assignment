package com.assignment.messageservice.messageprocessor;

import java.util.HashMap;
import java.util.Map;

import com.assignment.messageservice.adjustment.AddAjustmentOps;
import com.assignment.messageservice.adjustment.AdjustmentOps;
import com.assignment.messageservice.adjustment.MultiplyAdjustmentOps;
import com.assignment.messageservice.adjustment.SubtractAdjustmentOps;
import com.assignment.messageservice.adjustment.context.OperationContext;
import com.assignment.messageservice.request.message.Sales;
import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.request.message.SalesQuantityMessage;
import com.assignment.messageservice.response.SalesDetail;

public class MessageProcessorImpl implements IMessageProcessor {
	
	private Map<String, SalesDetail> salesDetailsMap;
	private static Map<String, AdjustmentOps> operationMap;
	private OperationContext context;
	
	static{
		operationMap = new HashMap<String, AdjustmentOps>(3);
		operationMap.put("ADD", new AddAjustmentOps());
		operationMap.put("SUBTRACT", new SubtractAdjustmentOps());
		operationMap.put("MULTIPLY", new MultiplyAdjustmentOps());
	}
	
	public MessageProcessorImpl() {
		salesDetailsMap = new HashMap<String, SalesDetail>();
		context = new OperationContext();
	}
	

	public void processMessage(Sales sales) {
		SalesDetail detail=null;
		if(salesDetailsMap.containsKey(sales.getProductType())){
			detail = salesDetailsMap.get(sales.getProductType());
			detail.setAmount(detail.getAmount()+sales.getAmount());
			detail.setNoOfSales(detail.getNoOfSales()+1);
		}else{
			detail = new SalesDetail();
			detail.setAmount(sales.getAmount());
			detail.setNoOfSales(1);
			detail.setProductType(sales.getProductType());
		}
		salesDetailsMap.put(detail.getProductType(), detail);
	}

	public void processMessage(SalesAdjustmentMessage adjustmentMessage) {
		
		AdjustmentOps adjustmentOps = operationMap.get(adjustmentMessage.getAdjustment().toUpperCase());
		if(null == adjustmentOps){
			throw new RuntimeException("Invalid Adjustment operation.");
		}
		context.setAdjustmentOps(adjustmentOps);
		SalesDetail detail = context.calculate(salesDetailsMap.get(adjustmentMessage.getSales().getProductType()), adjustmentMessage);
		salesDetailsMap.put(detail.getProductType(), detail);
	}

	public void processMessage(SalesQuantityMessage quantityMessage) {
		SalesDetail detail=null;
		if(salesDetailsMap.containsKey(quantityMessage.getSales().getProductType())){
			detail = salesDetailsMap.get(quantityMessage.getSales().getProductType());
			detail.setAmount(detail.getAmount()+quantityMessage.getSales().getAmount());
			detail.setNoOfSales(detail.getNoOfSales()+quantityMessage.getQuantity());
		}else{
			detail = new SalesDetail();
			detail.setAmount(quantityMessage.getSales().getAmount()*quantityMessage.getQuantity());
			detail.setNoOfSales(quantityMessage.getQuantity());
			detail.setProductType(quantityMessage.getSales().getProductType());
		}
		salesDetailsMap.put(detail.getProductType(), detail);

	}


	public Map<String, SalesDetail> getSalesDetail() {
		return salesDetailsMap;
	}

}
