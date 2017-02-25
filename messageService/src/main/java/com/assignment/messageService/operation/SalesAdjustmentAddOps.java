package com.assignment.messageService.operation;

import java.util.ArrayList;
import java.util.List;

import com.assignment.messageService.model.AdjustmentDetails;
import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.vo.SalesAdjustment;

public class SalesAdjustmentAddOps implements AdjustmentOps {

	

	public SalesReport calculate(SalesReport report, SalesAdjustment adjustment) {
		if(null!=report){
			report.setAmount(report.getAmount()+(report.getNumOfSales()*adjustment.getSales().getValue()));
			if(null != report.getAdjustmentDetails()){
				AdjustmentDetails details = new AdjustmentDetails();
				details.setAdustmentValue(adjustment.getSales().getValue());
				details.setOperation(adjustment.getAdjustmentOperation());
				report.getAdjustmentDetails().add(details);
			}else{
				List<AdjustmentDetails> adjustmentDetails = new ArrayList<AdjustmentDetails>();
				AdjustmentDetails details = new AdjustmentDetails();
				details.setAdustmentValue(adjustment.getSales().getValue());
				details.setOperation(adjustment.getAdjustmentOperation());
				adjustmentDetails.add(details);
				report.setAdjustmentDetails(adjustmentDetails);
			}
		}else{
			report = new SalesReport();
			report.setProductType(adjustment.getSales().getProductType());
			List<AdjustmentDetails> adjustmentDetails = new ArrayList<AdjustmentDetails>();
			AdjustmentDetails details = new AdjustmentDetails();
			details.setAdustmentValue(adjustment.getSales().getValue());
			details.setOperation(adjustment.getAdjustmentOperation());
			adjustmentDetails.add(details);
			report.setAdjustmentDetails(adjustmentDetails);
		}
		return report;
	}

}
