package com.assignment.messageService.operation;

import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.vo.SalesAdjustment;

public interface AdjustmentOps {
	
	public abstract SalesReport calculate(SalesReport report,SalesAdjustment adjustment);

}
