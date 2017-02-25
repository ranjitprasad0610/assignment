package com.assignment.messageService.operation;

import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.vo.SalesAdjustment;

public class OperationContext implements AdjustmentOps {
	
	private AdjustmentOps adjustmentOps;
	

	public AdjustmentOps getAdjustmentOps() {
		return adjustmentOps;
	}


	public void setAdjustmentOps(AdjustmentOps adjustmentOps) {
		this.adjustmentOps = adjustmentOps;
	}


	public SalesReport calculate(SalesReport report, SalesAdjustment adjustment) {
		return this.adjustmentOps.calculate(report, adjustment);
	}

}
