package com.assignment.messageService.task;

import java.util.Collection;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.assignment.messageService.model.AdjustmentDetails;
import com.assignment.messageService.model.SalesReport;
import com.assignment.messageService.processor.MessageProcessorImpl;
import com.assignment.messageService.vo.SalesMessage;


public class DisplayFifthTask implements Runnable {
	
	private SalesMessage [] messageArray;
	private CyclicBarrier barrier;
	private MessageProcessorImpl processor;
	
	public DisplayFifthTask(Object [] messageArray, CyclicBarrier barrier) {
		this.messageArray=(SalesMessage[]) messageArray;
		this.barrier=barrier;
		this.processor = new MessageProcessorImpl();
	}

	public void run() {
		System.out.println("System Pausing. No more message processing......!!");
		System.out.println("***********************************Fiftyth Task Start*************************************");
		for(SalesMessage message : messageArray){
			message.process(processor);
		}
		Collection<SalesReport> collectionReport= processor.getMapReport().values();
		for(SalesReport report:collectionReport){
			for(AdjustmentDetails detail:report.getAdjustmentDetails()){
				System.out.println("**       Product Type :: "+report.getProductType()+" ------ Adjustment Type :: "+detail.getOperation()+" ------ Adjustment Value :: "+detail.getAdustmentValue()+"    **");
			}
		}
		
		System.out.println("***********************************Fityth Task End*************************************");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
