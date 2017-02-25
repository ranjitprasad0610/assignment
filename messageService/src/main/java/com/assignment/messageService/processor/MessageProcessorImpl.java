package com.assignment.messageService.processor;

import java.util.HashMap;
import java.util.Map;

import com.assignment.messageService.enums.AdjustmentOperations;
import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.operation.AdjustmentOps;
import com.assignment.messageService.operation.OperationContext;
import com.assignment.messageService.operation.SalesAdjustmentAddOps;
import com.assignment.messageService.operation.SalesAdjustmentSubtractOps;
import com.assignment.messageService.vo.Sales;
import com.assignment.messageService.vo.SalesAdjustment;
import com.assignment.messageService.vo.SalesQuantity;

public class MessageProcessorImpl implements MessageProcessor {
	
	private Map<String, SalesReport> mapReport = new HashMap<String, SalesReport>();
	

	public void process(Sales sale) {
		
		SalesReport salesReport;
		if(mapReport.containsKey(sale.getProductType())){
			salesReport = mapReport.get(sale.getProductType());
			salesReport.setAmount(salesReport.getAmount()+sale.getValue());
			salesReport.setNumOfSales(salesReport.getNumOfSales()+1);
		}else{
			salesReport = new SalesReport();
			salesReport.setNumOfSales(1);
			salesReport.setAmount(sale.getValue());
			salesReport.setProductType(sale.getProductType());
		}
		mapReport.put(salesReport.getProductType(), salesReport);

	}

	public void process(SalesQuantity salesQuantity) {
		SalesReport salesReport;
		if(mapReport.containsKey(salesQuantity.getSales().getProductType())){
			salesReport = mapReport.get(salesQuantity.getSales().getProductType());
			salesReport.setNumOfSales(salesReport.getNumOfSales()+salesQuantity.getQuantity());
			salesReport.setAmount(salesReport.getAmount()+(salesQuantity.getSales().getValue()*salesQuantity.getQuantity()));
		}else{
			salesReport = new SalesReport();
			salesReport.setNumOfSales(salesQuantity.getQuantity());
			salesReport.setAmount(salesQuantity.getSales().getValue()*salesQuantity.getQuantity());
			salesReport.setProductType(salesQuantity.getSales().getProductType());
		}
		mapReport.put(salesReport.getProductType(), salesReport);
	}

	public void process(SalesAdjustment salesAdjustment) {
		SalesReport salesReport;
		OperationContext context = new OperationContext();
		if(mapReport.containsKey(salesAdjustment.getSales().getProductType())){
			salesReport = mapReport.get(salesAdjustment.getSales().getProductType());
			salesReport = executeOperation(salesAdjustment, salesReport,
					context);
			
		}else{
			salesReport = executeOperation(salesAdjustment, null,
					context);
		}
		mapReport.put(salesReport.getProductType(), salesReport);
	}

	public SalesReport executeOperation(SalesAdjustment salesAdjustment,
			SalesReport salesReport, OperationContext context) {
		AdjustmentOperations operations = AdjustmentOperations.valueOf(salesAdjustment.getAdjustmentOperation());
		switch (operations) {
		case ADD:
			AdjustmentOps addOps = new SalesAdjustmentAddOps();
			context.setAdjustmentOps(addOps);
			salesReport = context.calculate(salesReport, salesAdjustment);
			break;
		case SUBTRACT:
			AdjustmentOps substractOps = new SalesAdjustmentSubtractOps();
			context.setAdjustmentOps(substractOps);
			salesReport = context.calculate(salesReport, salesAdjustment);
			break;
		case MULTIPLY:
			AdjustmentOps multiplyOps = new SalesAdjustmentAddOps();
			context.setAdjustmentOps(multiplyOps);
			salesReport = context.calculate(salesReport, salesAdjustment);
			break;

		default:
			throw new RuntimeException("Invalid adjustment operation.");
		}
		return salesReport;
	}

	public Map<String, SalesReport> getMapReport() {
		return mapReport;
	}
	
	

}
