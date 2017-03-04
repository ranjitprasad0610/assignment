package com.assignment.messageservice.response;

public class Adjustment {
	
	private String operation;
	private int amount;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Adjustment [operation=" + operation + ", amount=" + amount
				+ "]";
	}
	
}
