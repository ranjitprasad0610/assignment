package com.assignment.messageservice.display;

import java.util.Map;

import com.assignment.messageservice.response.Adjustment;
import com.assignment.messageservice.response.SalesDetail;

public class DisplayFiftyMessageReport implements DisplayStrategy {

	public void display(Map<String, SalesDetail> report) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>START<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		for(SalesDetail detail : report.values()){
			for(Adjustment adjustment:detail.getAdjustments()){
				System.out.println("Product Type :: "+detail.getProductType()+"    Adjustment Type "+adjustment.getOperation()+"   Adjustment Amount ::"+adjustment.getAmount());
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>END<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

}
