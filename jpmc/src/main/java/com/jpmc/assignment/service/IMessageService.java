package com.jpmc.assignment.service;

import java.util.concurrent.BlockingQueue;

import com.jpmc.assignment.vo.Message;

public interface IMessageService {
	
	public abstract void publishTenthMessageSalesReport(BlockingQueue<Message> messageQueue);
	
	public abstract void publishFinalSalesDetails(BlockingQueue<BlockingQueue<Message>> mainMessageQueue);

}
