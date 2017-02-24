package com.jpmc.assignment.controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.jpmc.assignment.service.IMessageService;
import com.jpmc.assignment.service.impl.MessageServiceImpl;
import com.jpmc.assignment.vo.Message;


public class MessageController {
	
	private BlockingQueue<BlockingQueue<Message>> mainMessageQueue;
	BlockingQueue<Message> subMessageQueue;
	private IMessageService messageService;
	
	public MessageController() {
		subMessageQueue = new ArrayBlockingQueue<Message>(10);
		mainMessageQueue = new ArrayBlockingQueue<BlockingQueue<Message>>(5);
		messageService = new MessageServiceImpl();
	}
	
	/**
	 * 
	 * @param msg : Incoming message
	 * @return : true:Queuing successful false: Queuing unsuccessful
	 */
	public boolean processMessage(Message msg){
		if(null != msg){
			try {
				boolean receivedSuccessful = subMessageQueue.add(msg);
				if(subMessageQueue.remainingCapacity()==0){
					messageService.publishTenthMessageSalesReport(subMessageQueue);
					mainMessageQueue.add(subMessageQueue);
					if(mainMessageQueue.remainingCapacity()==0){
						System.out.println("Message processing service paused..!!");
						messageService.publishFinalSalesDetails(mainMessageQueue);
						System.exit(0);
					}
					subMessageQueue = new ArrayBlockingQueue<Message>(10);
				}
				return receivedSuccessful;
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
				return false;
			}
		
		}else{
			throw new RuntimeException("Invalid request");
		}
	}
	
	
}
