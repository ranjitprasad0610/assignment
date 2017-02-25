package com.assignment.messageService.exception;

public class MessageQueueBrokenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849852567688089883L;
	
	
	public MessageQueueBrokenException(String message) {
		super(message);
	}
	public MessageQueueBrokenException(String message,Throwable cause) {
		super(message,cause);
	}

}
