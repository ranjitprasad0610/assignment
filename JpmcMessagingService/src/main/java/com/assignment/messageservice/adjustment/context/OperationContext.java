package com.assignment.messageservice.adjustment.context;

import com.assignment.messageservice.adjustment.AdjustmentOps;
import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.response.SalesDetail;

public class OperationContext implements AdjustmentOps {
	
	private AdjustmentOps adjustmentOps;
	
	public AdjustmentOps getAdjustmentOps() {
		return adjustmentOps;
	}

	public void setAdjustmentOps(AdjustmentOps adjustmentOps) {
		this.adjustmentOps = adjustmentOps;
	}

	public SalesDetail calculate(SalesDetail salesDetail,
			SalesAdjustmentMessage adjustmentMessage) {

		return this.adjustmentOps.calculate(salesDetail, adjustmentMessage);
	}

}
