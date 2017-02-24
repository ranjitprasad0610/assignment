package com.jpmc.assignment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.jpmc.assignment.enums.ProductType;
import com.jpmc.assignment.model.AdjustmentDetails;
import com.jpmc.assignment.model.SalesReport;
import com.jpmc.assignment.service.IAdjustmentCalculator;
import com.jpmc.assignment.service.IMessageService;
import com.jpmc.assignment.vo.Message;
import com.jpmc.assignment.vo.Sales;
import com.jpmc.assignment.vo.SalesAdjustment;
import com.jpmc.assignment.vo.SalesQuantity;

public class MessageServiceImpl implements IMessageService {
	
	private Map<String,SalesReport> productReport = new HashMap<String,SalesReport>();
	
	private IAdjustmentCalculator adjustmentCalculator;
	
	public MessageServiceImpl() {
		adjustmentCalculator = new AdjustmentCalculatorImpl();
	}
	
/**
 * Publish 
 */
	public void publishTenthMessageSalesReport(
			BlockingQueue<Message> messageQueue) {
		Message [] messages = messageQueue.toArray(new Message[10]);
		populateProductReportMap(messages);
		DisplaySalesReport.displayTenthReport(productReport);
	}



	private void populateProductReportMap(Message[] messages) {
		for(Message msg: messages){
			List<Sales> salesList = msg.getSales();
			for(Sales sale : salesList){
				if(sale instanceof SalesQuantity){
					populateQuantity(sale);
				}else if(sale instanceof SalesAdjustment){
					populateAdjustments(sale);
				}else if(sale instanceof Sales){
					populateQuantityAsOne(sale);
				}
			}
		}
	}


	private void populateAdjustments(Sales sale) {
		if(productReport.containsKey(sale.getProductType().toLowerCase())){
			SalesReport report = productReport.get(sale.getProductType().toLowerCase());
			if(null != report.getAdjustmentDetails()){
				AdjustmentDetails adjustmentDetails = new AdjustmentDetails();
				adjustmentDetails.setOperation(((SalesAdjustment) sale).getAdjustmentOperation().toUpperCase());
				adjustmentDetails.setAdustmentValue(sale.getValue());
				report.getAdjustmentDetails().add(adjustmentDetails);
				adjustmentCalculator.calculateAdjustment(report, adjustmentDetails);
			}else{
				List<AdjustmentDetails> adjustmentDetails = new ArrayList<AdjustmentDetails>();
				AdjustmentDetails adjustmentDetail = new AdjustmentDetails();
				adjustmentDetail.setOperation(((SalesAdjustment) sale).getAdjustmentOperation().toUpperCase());
				adjustmentDetail.setAdustmentValue(sale.getValue());
				adjustmentDetails.add(adjustmentDetail);
				report.setAdjustmentDetails(adjustmentDetails);
				adjustmentCalculator.calculateAdjustment(report, adjustmentDetail);
			}
			
		}else{
			SalesReport report = new SalesReport();
			report.setProductType(ProductType.valueOf(sale.getProductType().toUpperCase()));
			List<AdjustmentDetails> adjustmentDetails = new ArrayList<AdjustmentDetails>();
			AdjustmentDetails adjustmentDetail = new AdjustmentDetails();
			adjustmentDetail.setOperation(((SalesAdjustment) sale).getAdjustmentOperation().toUpperCase());
			adjustmentDetail.setAdustmentValue(sale.getValue());
			adjustmentDetails.add(adjustmentDetail);
			report.setAdjustmentDetails(adjustmentDetails);
			adjustmentCalculator.calculateAdjustment(report, adjustmentDetail);
			productReport.put(report.getProductType().getValue(), report);
		}
	}


	private void populateQuantityAsOne(Sales sale) {
		if(productReport.containsKey(sale.getProductType().toLowerCase())){
			SalesReport report = productReport.get(sale.getProductType().toLowerCase());
			report.setNumOfSales(report.getNumOfSales()+1);
			report.setAmount(report.getAmount()+(1*sale.getValue()));
			
		}else{
			SalesReport report = new SalesReport();
			report.setProductType(ProductType.valueOf(sale.getProductType().toUpperCase()));
			report.setNumOfSales(1);
			report.setAmount(sale.getValue()*report.getNumOfSales());
			productReport.put(report.getProductType().getValue(), report);
		}
	}


	private void populateQuantity(Sales sale) {
		if(productReport.containsKey(sale.getProductType().toLowerCase())){
			SalesReport report = productReport.get(sale.getProductType().toLowerCase());
			report.setNumOfSales(report.getNumOfSales()+((SalesQuantity) sale).getQuantity());
			report.setAmount(report.getAmount()+(((SalesQuantity) sale).getQuantity()*sale.getValue()));
			
		}else{
			SalesReport report = new SalesReport();
			report.setProductType(ProductType.valueOf(sale.getProductType().toUpperCase()));
			report.setNumOfSales(((SalesQuantity) sale).getQuantity());
			report.setAmount(sale.getValue()*report.getNumOfSales());
			productReport.put(report.getProductType().getValue(), report);
		}
	}


	public void publishFinalSalesDetails(
			BlockingQueue<BlockingQueue<Message>> mainMessageQueue) {
		DisplaySalesReport.displayFifthReport(productReport);
	}

	

}
