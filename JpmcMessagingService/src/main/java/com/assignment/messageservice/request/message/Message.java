package com.assignment.messageservice.request.message;

import java.util.Collections;
import java.util.List;

public final class Message {
	
	private final List<SalesMessage> salesMessages;
	
	public Message(List<SalesMessage> salesMessages) {
		this.salesMessages=Collections.unmodifiableList(salesMessages);
	}

	public List<SalesMessage> getSalesMessages() {
		return Collections.unmodifiableList(salesMessages);
	}

	@Override
	public String toString() {
		return "Message [salesMessages=" + getSalesMessages() + "]";
	}
	
	

}
