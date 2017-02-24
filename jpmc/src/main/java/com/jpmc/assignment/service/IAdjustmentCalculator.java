package com.jpmc.assignment.service;

import com.jpmc.assignment.model.AdjustmentDetails;
import com.jpmc.assignment.model.SalesReport;

public interface IAdjustmentCalculator {
	
	public abstract long calculateAdjustment(SalesReport report,AdjustmentDetails adjustmentDetails);

}
