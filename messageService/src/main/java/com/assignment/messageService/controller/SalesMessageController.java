package com.assignment.messageService.controller;

import com.assignment.messageService.component.MessageQueue;
import com.assignment.messageService.exception.MessageQueueBrokenException;
import com.assignment.messageService.vo.SalesMessage;

public class SalesMessageController {
	
	private MessageQueue messageQueue;
	
	public SalesMessageController() {
		super();
		this.messageQueue = new MessageQueue();
	}

	public boolean reciveMessage(SalesMessage message){
		try {
			return messageQueue.put(message);
		} catch (MessageQueueBrokenException e) {
			e.printStackTrace();
			return false;
		}
	}

}
