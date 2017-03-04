package com.assignment.messageservice.display;

import java.util.Map;

import com.assignment.messageservice.response.SalesDetail;

public interface DisplayStrategy {
	
	public abstract void display(Map<String, SalesDetail> report);

}
