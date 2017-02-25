package com.assignment.messageService.task;

import java.util.Collection;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.processor.MessageProcessorImpl;
import com.assignment.messageService.vo.SalesMessage;


public class DisplayTenthTask implements Runnable {
	
	private SalesMessage [] messageArray;
	private CyclicBarrier barrier;
	private MessageProcessorImpl processor;
	
	public DisplayTenthTask(Object [] messageArray, CyclicBarrier barrier) {
		this.messageArray=(SalesMessage[]) messageArray;
		this.barrier=barrier;
		this.processor = new MessageProcessorImpl();
	}

	public void run() {
		System.out.println("***********************************Tenth Task Start*************************************");
		for(SalesMessage message : messageArray){
			message.process(processor);
		}
		Collection<SalesReport> collectionReport= processor.getMapReport().values();
		for(SalesReport report:collectionReport){
			System.out.println("**       Product Type :: "+report.getProductType()+" ------ Number Of Sales :: "+report.getNumOfSales()+" ------ Amount :: "+report.getAmount()+"    **");
		}
		
		System.out.println("***********************************Tenth Task End*************************************");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
