package com.jpmc.assignment.service.impl;

import java.util.Map;

import com.jpmc.assignment.model.SalesReport;
import com.jpmc.assignment.service.IAdjustmentCalculator;

public class DisplaySalesData {
	public Map<String, SalesReport> productReport;
	public IAdjustmentCalculator adjustmentCalculator;

	public DisplaySalesData(Map<String, SalesReport> productReport) {
		this.productReport = productReport;
	}
}