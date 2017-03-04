package com.assignment.messageservice.adjustment;

import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.response.SalesDetail;

public interface AdjustmentOps {
	
	public SalesDetail calculate(SalesDetail salesDetail,SalesAdjustmentMessage adjustmentMessage);

}
