package com.assignment.messageservice.request.message;

import com.assignment.messageservice.messageprocessor.IMessageProcessor;


public interface SalesMessage {
	
	public void executeMessage(IMessageProcessor messageProcessor);

}
