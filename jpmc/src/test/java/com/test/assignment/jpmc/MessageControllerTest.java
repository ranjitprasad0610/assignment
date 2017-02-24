package com.test.assignment.jpmc;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.assignment.controller.MessageController;
import com.jpmc.assignment.vo.Message;
import com.jpmc.assignment.vo.Sales;
import com.jpmc.assignment.vo.SalesAdjustment;
import com.jpmc.assignment.vo.SalesQuantity;

public class MessageControllerTest {
	
	MessageController messageController;
	List<Message> fiftyMessageData;
	List<Message> noData;
	List<Message> tenMessageData;
	List<Message> onlyAdjustmentData;

	@Before
	public void setUp() throws Exception {
		messageController = new MessageController();
		fiftyMessageData = getMessageList();
		tenMessageData = getTenthMassageData();
		noData = getEmptyListData();
		onlyAdjustmentData = getOnlyAdjustmentMessages();
	}
	
	@Test
	public void testOnlyAdjustments(){
		List<Message> messages = getOnlyAdjustmentMessages();
		List<Boolean> responses = new ArrayList<Boolean>();
		for(Message msg: messages){
			responses.add(messageController.processMessage(msg));
		}
		Assert.assertEquals(messages.size(), responses.size());
	}
	
	@Test
	public void testFiftyReceiveMessage() {
		List<Message> messages = getMessageList();
		List<Boolean> responses = new ArrayList<Boolean>();
		for(Message msg: messages){
			responses.add(messageController.processMessage(msg));
		}
		Assert.assertEquals(messages.size(), responses.size());
		
	}
	
	@Test
	public void testTenReceiveMessage() {
		List<Message> messages = getTenthMassageData();
		List<Boolean> responses = new ArrayList<Boolean>();
		for(Message msg: messages){
			responses.add(messageController.processMessage(msg));
		}
		Assert.assertEquals(messages.size(), responses.size());
	}

	
	@Test
	public void testNoReceiveMessage() {
		List<Message> messages = getEmptyListData();
		List<Boolean> responses = new ArrayList<Boolean>();
		for(Message msg: messages){
			responses.add(messageController.processMessage(msg));
		}
		Assert.assertEquals(messages.isEmpty(), responses.isEmpty());
	}


	private List<Message> getEmptyListData() {
		List<Message> messages = new ArrayList<Message>();
		return messages;
	}

	private List<Message> getTenthMassageData() {
		
		List<Message> messages = new ArrayList<Message>();
		
		Sales sale1 = new Sales();
		sale1.setProductType("apple");
		sale1.setValue(10);
		
		Sales sale2 = new Sales();
		sale2.setProductType("orange");
		sale2.setValue(5);
		
		List<Sales> sales1 = new ArrayList<Sales>();
		sales1.add(sale1);
		sales1.add(sale2);
		
		Message message = new Message(sales1);
		
		SalesQuantity sale3 = new SalesQuantity();
		sale3.setProductType("kiwi");
		sale3.setValue(10);
		sale3.setQuantity(4);
		
		SalesQuantity sale4 = new SalesQuantity();
		sale4.setProductType("melons");
		sale4.setValue(5);
		sale4.setQuantity(10);
		
		List<Sales> sales2 = new ArrayList<Sales>();
		sales2.add(sale3);
		sales2.add(sale4);
		
		Message message2 = new Message(sales2);
		
		SalesAdjustment sale5 = new SalesAdjustment();
		sale5.setProductType("pear");
		sale5.setValue(10);
		sale5.setAdjustmentOperation("add");
		
		SalesAdjustment sale6 = new SalesAdjustment();
		sale6.setProductType("banana");
		sale6.setValue(5);
		sale6.setAdjustmentOperation("subtract");
		
		List<Sales> sales3 = new ArrayList<Sales>();
		sales3.add(sale5);
		sales3.add(sale6);
		
		Message message3 = new Message(sales3);
		
		Sales sale7 = new Sales();
		sale7.setProductType("apricot");
		sale7.setValue(10);
		
		Sales sale8 = new Sales();
		sale8.setProductType("fig");
		sale8.setValue(5);
		
		List<Sales> sales4 = new ArrayList<Sales>();
		sales4.add(sale7);
		sales4.add(sale8);
		
		Message message4 = new Message(sales4);
		
		Message message5 = new Message(sales4);
		Message message6 = new Message(sales4);
		Message message7 = new Message(sales4);
		Message message8 = new Message(sales4);
		Message message9 = new Message(sales4);
		Message message10 = new Message(sales4);
		
		messages.add(message);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		messages.add(message5);
		messages.add(message6);
		messages.add(message7);
		messages.add(message8);
		messages.add(message9);
		messages.add(message10);
		return messages;
	}

	
	
	

	private List<Message> getOnlyAdjustmentMessages() {
		List<Message> messages = new ArrayList<Message>();
		SalesAdjustment sale1 = new SalesAdjustment();
		sale1.setProductType("apple");
		sale1.setValue(10);
		sale1.setAdjustmentOperation("add");
		
		SalesAdjustment sale2 = new SalesAdjustment();
		sale2.setProductType("orange");
		sale2.setValue(5);
		sale2.setAdjustmentOperation("subtract");
		
		List<Sales> sales1 = new ArrayList<Sales>();
		sales1.add(sale1);
		sales1.add(sale2);
		
		Message message = new Message(sales1);
		
		SalesAdjustment sale3 = new SalesAdjustment();
		sale3.setProductType("kiwi");
		sale3.setValue(10);
		sale3.setAdjustmentOperation("multiply");
		
		SalesAdjustment sale4 = new SalesAdjustment();
		sale4.setProductType("melons");
		sale4.setValue(5);
		sale4.setAdjustmentOperation("multiply");
		
		List<Sales> sales2 = new ArrayList<Sales>();
		sales2.add(sale3);
		sales2.add(sale4);
		
		Message message2 = new Message(sales2);
		
		SalesAdjustment sale5 = new SalesAdjustment();
		sale5.setProductType("pear");
		sale5.setValue(10);
		sale5.setAdjustmentOperation("add");
		
		SalesAdjustment sale6 = new SalesAdjustment();
		sale6.setProductType("banana");
		sale6.setValue(5);
		sale6.setAdjustmentOperation("subtract");
		
		List<Sales> sales3 = new ArrayList<Sales>();
		sales3.add(sale5);
		sales3.add(sale6);
		
		Message message3 = new Message(sales3);
		
		SalesAdjustment sale7 = new SalesAdjustment();
		sale7.setProductType("apricot");
		sale7.setValue(10);
		sale7.setAdjustmentOperation("add");
		
		SalesAdjustment sale8 = new SalesAdjustment();
		sale8.setProductType("fig");
		sale8.setValue(5);
		sale8.setAdjustmentOperation("subtract");
		
		List<Sales> sales4 = new ArrayList<Sales>();
		sales4.add(sale7);
		sales4.add(sale8);
		
		Message message4 = new Message(sales4);
		
		Message message5 = new Message(sales4);
		Message message6 = new Message(sales4);
		Message message7 = new Message(sales4);
		Message message8 = new Message(sales4);
		Message message9 = new Message(sales4);
		Message message10 = new Message(sales4);
		Message message11 = new Message(sales4);
		
		messages.add(message);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		messages.add(message5);
		messages.add(message6);
		messages.add(message7);
		messages.add(message8);
		messages.add(message9);
		messages.add(message10);
		messages.add(message11);
		
		
		return messages;
	}

	

	private List<Message> getMessageList() {
		List<Message> messages = new ArrayList<Message>();
		
		Sales sale1 = new Sales();
		sale1.setProductType("apple");
		sale1.setValue(10);
		
		Sales sale2 = new Sales();
		sale2.setProductType("orange");
		sale2.setValue(5);
		
		List<Sales> sales1 = new ArrayList<Sales>();
		sales1.add(sale1);
		sales1.add(sale2);
		
		Message message = new Message(sales1);
		
		SalesQuantity sale3 = new SalesQuantity();
		sale3.setProductType("kiwi");
		sale3.setValue(10);
		sale3.setQuantity(4);
		
		SalesQuantity sale4 = new SalesQuantity();
		sale4.setProductType("melons");
		sale4.setValue(5);
		sale4.setQuantity(10);
		
		List<Sales> sales2 = new ArrayList<Sales>();
		sales2.add(sale3);
		sales2.add(sale4);
		
		Message message2 = new Message(sales2);
		
		SalesAdjustment sale5 = new SalesAdjustment();
		sale5.setProductType("pear");
		sale5.setValue(10);
		sale5.setAdjustmentOperation("add");
		
		SalesAdjustment sale6 = new SalesAdjustment();
		sale6.setProductType("banana");
		sale6.setValue(5);
		sale6.setAdjustmentOperation("subtract");
		
		List<Sales> sales3 = new ArrayList<Sales>();
		sales3.add(sale5);
		sales3.add(sale6);
		
		Message message3 = new Message(sales3);
		
		Sales sale7 = new Sales();
		sale7.setProductType("apricot");
		sale7.setValue(10);
		
		Sales sale8 = new Sales();
		sale8.setProductType("fig");
		sale8.setValue(5);
		
		List<Sales> sales4 = new ArrayList<Sales>();
		sales4.add(sale7);
		sales4.add(sale8);
		
		Message message4 = new Message(sales4);
		
		Message message5 = new Message(sales4);
		Message message6 = new Message(sales4);
		Message message7 = new Message(sales4);
		Message message8 = new Message(sales4);
		Message message9 = new Message(sales4);
		Message message10 = new Message(sales4);
		Message message11 = new Message(sales4);
		Message message12 = new Message(sales4);
		Message message13 = new Message(sales4);
		Message message14 = new Message(sales4);
		Message message15 = new Message(sales4);
		Message message16 = new Message(sales4);
		Message message17 = new Message(sales4);
		Message message18 = new Message(sales4);
		Message message19 = new Message(sales4);
		Message message20 = new Message(sales4);
		Message message21 = new Message(sales4);
		Message message22 = new Message(sales4);
		Message message23 = new Message(sales4);
		Message message24 = new Message(sales4);
		Message message25 = new Message(sales4);
		Message message26 = new Message(sales4);
		Message message27 = new Message(sales4);
		Message message28 = new Message(sales4);
		Message message29 = new Message(sales4);
		Message message30 = new Message(sales4);
		Message message31 = new Message(sales4);
		Message message32 = new Message(sales4);
		Message message33 = new Message(sales4);
		Message message34 = new Message(sales4);
		Message message35 = new Message(sales4);
		Message message36 = new Message(sales4);
		Message message37 = new Message(sales4);
		Message message38 = new Message(sales4);
		Message message39 = new Message(sales4);
		Message message40 = new Message(sales4);
		Message message41 = new Message(sales4);
		Message message42 = new Message(sales4);
		Message message43 = new Message(sales4);
		Message message44 = new Message(sales4);
		Message message45 = new Message(sales4);
		Message message46 = new Message(sales4);
		Message message47 = new Message(sales4);
		Message message48 = new Message(sales4);
		Message message49 = new Message(sales4);
		Message message50 = new Message(sales4);
		Message message51 = new Message(sales4);
		
		
		messages.add(message);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		messages.add(message5);
		messages.add(message6);
		messages.add(message7);
		messages.add(message8);
		messages.add(message9);
		messages.add(message10);
		messages.add(message11);
		messages.add(message12);
		messages.add(message13);
		messages.add(message14);
		messages.add(message15);
		messages.add(message16);
		messages.add(message17);
		messages.add(message18);
		messages.add(message19);
		messages.add(message20);
		messages.add(message21);
		messages.add(message22);
		messages.add(message23);
		messages.add(message24);
		messages.add(message25);
		messages.add(message26);
		messages.add(message27);
		messages.add(message28);
		messages.add(message29);
		messages.add(message30);
		messages.add(message31);
		messages.add(message32);
		messages.add(message33);
		messages.add(message34);
		messages.add(message35);
		messages.add(message36);
		messages.add(message37);
		messages.add(message38);
		messages.add(message39);
		messages.add(message40);
		messages.add(message41);
		messages.add(message42);
		messages.add(message43);
		messages.add(message44);
		messages.add(message45);
		messages.add(message46);
		messages.add(message47);
		messages.add(message48);
		messages.add(message49);
		messages.add(message50);
		messages.add(message51);
		
		return messages;
	}

}
