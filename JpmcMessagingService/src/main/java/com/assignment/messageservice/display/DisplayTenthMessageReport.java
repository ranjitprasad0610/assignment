package com.assignment.messageservice.display;

import java.util.Map;

import com.assignment.messageservice.response.SalesDetail;

public class DisplayTenthMessageReport implements DisplayStrategy {

	public void display(Map<String, SalesDetail> report) {
		System.out.println("**********************************************START*****************************************************");
		for(SalesDetail detail : report.values()){
			System.out.println("Product Type :: "+detail.getProductType()+"     Nuber of Sales :: "+detail.getNoOfSales()+"        Amount ::  "+detail.getAmount());
		}
		System.out.println("**********************************************END*****************************************************");
	}

}
