package com.jpmc.assignment.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue<E> {
	
	private BlockingQueue<E> queue;
	
	public MessageQueue() {
		queue = new ArrayBlockingQueue<E>(10);
	}

	public BlockingQueue<E> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<E> queue) {
		this.queue = queue;
	}

}
