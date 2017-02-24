package com.jpmc.assignment.service.impl;

import com.jpmc.assignment.enums.AdjustmentOperations;
import com.jpmc.assignment.model.AdjustmentDetails;
import com.jpmc.assignment.model.SalesReport;
import com.jpmc.assignment.service.IAdjustmentCalculator;

public class AdjustmentCalculatorImpl implements IAdjustmentCalculator {

	public long calculateAdjustment(SalesReport report,
			AdjustmentDetails adjustmentDetails) {
		AdjustmentOperations operation = AdjustmentOperations.valueOf(adjustmentDetails.getOperation());
		switch (operation) {
		case ADD:
		{
			int numSales = report.getNumOfSales();
			long amount = report.getAmount();
			int addValue = adjustmentDetails.getAdustmentValue();
			return (addValue*numSales)+amount;
		}
			
		case MULTIPLY:
		{
			int numSales = report.getNumOfSales();
			long amount = report.getAmount();
			int addValue = adjustmentDetails.getAdustmentValue();
			return (addValue*numSales)*amount;
		}
		case SUBTRACT:
		{
			int numSales = report.getNumOfSales();
			long amount = report.getAmount();
			int addValue = adjustmentDetails.getAdustmentValue();
			return (addValue*numSales)-amount;
		}
		default:
			throw new RuntimeException("Invalid adjustment operation");
		}
	}

}
