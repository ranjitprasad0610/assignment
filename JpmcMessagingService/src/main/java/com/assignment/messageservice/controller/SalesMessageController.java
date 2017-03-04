package com.assignment.messageservice.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.assignment.messageservice.display.DisplayFiftyMessageReport;
import com.assignment.messageservice.display.DisplayStrategy;
import com.assignment.messageservice.display.DisplayTenthMessageReport;
import com.assignment.messageservice.messageprocessor.IMessageProcessor;
import com.assignment.messageservice.messageprocessor.MessageProcessorImpl;
import com.assignment.messageservice.request.message.Message;
import com.assignment.messageservice.request.message.SalesMessage;
import com.assignment.messageservice.response.SalesDetail;

public class SalesMessageController {
	
	private Map<String, SalesDetail> salesData;
	private List<Message> messages;
	private int tenthMessageCounter;
	private int fiftyMessageCounter;
	private static final Map<String, DisplayStrategy> displayStrategyMap;
	private static final String TENTH_MESG_DISPLAY="Ten";
	private static final String FIFTY_MESG_DISPLAY="Fifty";
	
	static{
		displayStrategyMap = new HashMap<String, DisplayStrategy>();
		displayStrategyMap.put(TENTH_MESG_DISPLAY, new DisplayTenthMessageReport());
		displayStrategyMap.put(FIFTY_MESG_DISPLAY, new DisplayFiftyMessageReport());
	}
	
	public SalesMessageController() {
		salesData = new HashMap<String, SalesDetail>();
		messages = new LinkedList<Message>();
		tenthMessageCounter = 0;
		fiftyMessageCounter = 0;
	}
	
	public boolean receiveMessage(Message message){
		IMessageProcessor messageProcessor = new MessageProcessorImpl();
		if(null != message && null != message.getSalesMessages()){
			try {
				
				incrementMessageCounters();
				stopAcceptingMessageAfterFiftyMessages();
				
				messages.add(message);
				for(SalesMessage salesMessage:message.getSalesMessages()){
					salesMessage.executeMessage(messageProcessor);
				}
				boolean messageStatus = calculateSalesData(salesData,messageProcessor.getSalesDetail());
				
				displayEveryTenthmessageReport();
				displayFiftythMessageReport();
					
				return messageStatus;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Message not procesed "+message);
				return false;
			}
		}
		return false;
	}

	private void displayFiftythMessageReport() {
		if(fiftyMessageCounter == 50){
			System.out.println("System Pausing..!!");
			displayStrategyMap.get(FIFTY_MESG_DISPLAY).display(salesData);
		}
	}

	private void displayEveryTenthmessageReport() {
		if(tenthMessageCounter  == 10){
			tenthMessageCounter = 0;
			displayStrategyMap.get(TENTH_MESG_DISPLAY).display(salesData);
		}
	}

	private void incrementMessageCounters() {
		tenthMessageCounter++;
		fiftyMessageCounter++;
	}

	private void stopAcceptingMessageAfterFiftyMessages() {
		if(fiftyMessageCounter == 51){
			System.exit(0);
		}
	}

	
	private boolean calculateSalesData(Map<String, SalesDetail> reportData,
			Map<String, SalesDetail> messageDetails) {
		if(null != messageDetails){
			Set<String> keySet = messageDetails.keySet();
			for(String productKey : keySet){
				if(reportData.containsKey(productKey)){
					SalesDetail reportDetail = reportData.get(productKey);
					SalesDetail messageDetail = messageDetails.get(productKey);
					messageDetail.setAmount(messageDetail.getAmount()+reportDetail.getAmount());
					messageDetail.setNoOfSales(messageDetail.getNoOfSales()+reportDetail.getNoOfSales());
					messageDetail.getAdjustments().addAll(reportDetail.getAdjustments());
					reportData.put(productKey, messageDetail);
				}else{
					reportData.put(productKey, messageDetails.get(productKey));
				}
			}
			return true;
		}
		return false;
	}

	public Map<String, SalesDetail> getSalesData() {
		return salesData;
	}

	public List<Message> getMessages() {
		return messages;
	}

}
