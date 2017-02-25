package com.assignment.messageService.component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.assignment.messageService.exception.MessageQueueBrokenException;
import com.assignment.messageService.exception.MessageQueueFullException;
import com.assignment.messageService.task.DisplayFifthTask;
import com.assignment.messageService.task.DisplayTenthTask;
import com.assignment.messageService.vo.SalesMessage;

/**
 * 
 * @author Ranjit
 *
 * @param <E>: Message Type
 * 
 * @throws IllegalStateException: When the MessageQueue is full.
 * 
 * @throws MessageQueueBrokenException: When their is an exception while message enqueue.
 * 
 * This queue is created with specific behavior where size reflects every 10 message
 * and prints the message on console. 
 * 
 * After every 50th Message it prints the entire queue object
 */
public class MessageQueue {
	
	private BlockingQueue<SalesMessage> secondaryQueue;
	private BlockingQueue<SalesMessage> primaryQueue;
	private CyclicBarrier barrier;
	private ExecutorService printService;
	
	private final int DEFAULT_CAPACITY=50;
	private final int UNIT_SIZE=10;
	
	public MessageQueue() {
		primaryQueue = new ArrayBlockingQueue<SalesMessage>(UNIT_SIZE);
		secondaryQueue = new ArrayBlockingQueue<SalesMessage>(DEFAULT_CAPACITY);
		printService = Executors.newSingleThreadExecutor();
		barrier = new CyclicBarrier(2);
	}
	
	public MessageQueue(int maxSize,int unitSize) {
		primaryQueue = new ArrayBlockingQueue<SalesMessage>(unitSize);
		secondaryQueue = new ArrayBlockingQueue<SalesMessage>(maxSize);
	}
	
	public boolean put(SalesMessage e) throws MessageQueueBrokenException, MessageQueueFullException  {
		if(null == e){
			throw new RuntimeException("Invalid Message..");
		}
		
		if(secondaryQueue.remainingCapacity()==0){
			throw new IllegalStateException("Queue Capacity full..!!");
		}
		try {
			if (primaryQueue.remainingCapacity() > 1) {
				return primaryQueue.offer(e);
			} else if (primaryQueue.remainingCapacity() == 1) {
				primaryQueue.offer(e);
				while (!primaryQueue.isEmpty()
						&& secondaryQueue.remainingCapacity() > 0) {
					secondaryQueue.offer(primaryQueue.poll());
				}
				printService.submit(new DisplayTenthTask(secondaryQueue.toArray(new SalesMessage[0]),barrier));
				barrier.await();
				if(secondaryQueue.remainingCapacity() == 0){
					printService.submit(new DisplayFifthTask(secondaryQueue.toArray(new SalesMessage[0]),barrier));
					barrier.await();
				}
				return true;
			}
		} catch (InterruptedException e1) {
			throw new MessageQueueBrokenException("Message was not enqued",e1);
		} catch (BrokenBarrierException e1) {
			throw new MessageQueueBrokenException("Message was not enqued",e1);
		}
		return false;
	}
	
	public int getSize(){
		return secondaryQueue.size();
	}

	}



