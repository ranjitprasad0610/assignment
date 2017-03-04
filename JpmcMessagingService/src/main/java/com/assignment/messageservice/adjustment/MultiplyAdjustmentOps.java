package com.assignment.messageservice.adjustment;

import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.response.Adjustment;
import com.assignment.messageservice.response.SalesDetail;

public class MultiplyAdjustmentOps implements AdjustmentOps {

	public SalesDetail calculate(SalesDetail salesDetail,
			SalesAdjustmentMessage adjustmentMessage) {
		if(null != salesDetail){
			Adjustment adjustment = new Adjustment();
			adjustment.setAmount(adjustmentMessage.getSales().getAmount());
			adjustment.setOperation(adjustmentMessage.getAdjustment());
			salesDetail.getAdjustments().add(adjustment);
			salesDetail.setAmount(salesDetail.getAmount()*(salesDetail.getNoOfSales()*adjustment.getAmount()));
		}else{
			salesDetail = new SalesDetail();
			Adjustment adjustment = new Adjustment();
			adjustment.setAmount(adjustmentMessage.getSales().getAmount());
			adjustment.setOperation(adjustmentMessage.getAdjustment());
			salesDetail.getAdjustments().add(adjustment);
		}
		return salesDetail;
	}

}
