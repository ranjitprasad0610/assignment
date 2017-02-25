package com.assignment.messageService.vo;

import com.assignment.messageService.processor.MessageProcessor;

public interface SalesMessage {
	
	public abstract void process(MessageProcessor processor);

}
