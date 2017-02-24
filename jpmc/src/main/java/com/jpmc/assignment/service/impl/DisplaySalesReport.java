package com.jpmc.assignment.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jpmc.assignment.model.AdjustmentDetails;
import com.jpmc.assignment.model.SalesReport;

public class DisplaySalesReport {

	public static void displayTenthReport(Map<String, SalesReport> productReport) {

		Set<String> keySet = productReport.keySet();
		System.out
				.println("******************************************************10th Report Display Start***********************************************");
		for (String key : keySet) {
			SalesReport report = productReport.get(key);
			System.out.print("Product Type :: "
					+ report.getProductType().getValue()
					+ ", Number Of Sales :: " + report.getNumOfSales()
					+ ", Total Amount :: " + report.getAmount());
			System.out.println("");
		}
		System.out
				.println("******************************************************10th Report Display End***********************************************");
	}

	public static void displayFifthReport(Map<String, SalesReport> productReport) {
		Set<String> keySet = productReport.keySet();
		System.out
				.println("******************************************************50th Report Display Start***********************************************");
		for (String key : keySet) {
			SalesReport report = productReport.get(key);
			List<AdjustmentDetails> adjustmentDetails = report
					.getAdjustmentDetails();
			if (null != adjustmentDetails) {
				for (AdjustmentDetails details : adjustmentDetails) {
					System.out.print("Product Type :: "
							+ report.getProductType().getValue()
							+ ", Adjustment Operation :: "
							+ details.getOperation()
							+ ", Adjustment Amount :: "
							+ details.getAdustmentValue());
					System.out.println("");
				}
			}
		}
		System.out
				.println("******************************************************50th Report Display End***********************************************");

	}

}
