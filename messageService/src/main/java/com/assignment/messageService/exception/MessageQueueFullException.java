package com.assignment.messageService.exception;

public class MessageQueueFullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public MessageQueueFullException(String message) {
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
}
