package com.assignment.messageservice.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.assignment.messageservice.controller.SalesMessageController;
import com.assignment.messageservice.request.message.Message;
import com.assignment.messageservice.request.message.Sales;
import com.assignment.messageservice.request.message.SalesAdjustmentMessage;
import com.assignment.messageservice.request.message.SalesMessage;
import com.assignment.messageservice.request.message.SalesQuantityMessage;
import com.assignment.messageservice.response.SalesDetail;

public class SalesMessageControllerTest {

	private SalesMessageController controller;

	@Before
	public void setUp() throws Exception {
		controller = new SalesMessageController();
	}

	@Test
	public void testSuccessMessageCalculation() {
		Sales sales = new Sales("Apple", 10);
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(sales);
		
		Message message = new Message(salesMessages);
		boolean messageStatus = controller.receiveMessage(message);
		List<SalesDetail> details= new ArrayList<SalesDetail>(controller.getSalesData().values());
		SalesDetail detail = details.get(0);
		Assert.assertTrue(messageStatus);
		Assert.assertEquals(detail.getProductType(), sales.getProductType());
		Assert.assertEquals(detail.getAmount(), sales.getAmount());
	}
	
	@Test
	public void testFailureReceiveMessage() {
		
		boolean messageStatus = controller.receiveMessage(null);
		List<SalesDetail> details= new ArrayList<SalesDetail>(controller.getSalesData().values());
		Assert.assertEquals(0, details.size());
		Assert.assertFalse(messageStatus);
	}
	
	@Test
	public void testQuantityReceiveMessage() {
		Sales sales = new Sales("Apple", 10);
		SalesQuantityMessage quantityMessage = new SalesQuantityMessage(sales, 2);
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(quantityMessage);
		
		Message message = new Message(salesMessages);
		controller.receiveMessage(message);
		List<SalesDetail> details = new ArrayList<SalesDetail>(controller.getSalesData().values());
		SalesDetail detail = details.get(0);
		Assert.assertEquals(detail.getProductType(), sales.getProductType());
		Assert.assertEquals(detail.getAmount(), sales.getAmount()*quantityMessage.getQuantity());
		
	}
	
	@Test
	public void testAdjustmentReceiveMessage() {
		Sales sales = new Sales("Apple", 10);
		SalesQuantityMessage quantityMessage = new SalesQuantityMessage(sales, 2);
		SalesAdjustmentMessage adjustmentMessage = new SalesAdjustmentMessage(sales, "ADD");
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(quantityMessage);
		salesMessages.add(adjustmentMessage);
		
		Message message = new Message(salesMessages);
		controller.receiveMessage(message);
		List<SalesDetail> details = new ArrayList<SalesDetail>(controller.getSalesData().values());
		SalesDetail detail = details.get(0);
		Assert.assertEquals(detail.getProductType(), sales.getProductType());
		Assert.assertEquals((sales.getAmount()+sales.getAmount())*quantityMessage.getQuantity(),detail.getAmount());
		
	}
	
	@Test
	public void testInvalidAdjustmentMessage() {
		Sales sales = new Sales("Apple", 10);
		SalesQuantityMessage quantityMessage = new SalesQuantityMessage(sales, 2);
		SalesAdjustmentMessage adjustmentMessage = new SalesAdjustmentMessage(sales, "DIVIDE");
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(quantityMessage);
		salesMessages.add(adjustmentMessage);
		
		Message message = new Message(salesMessages);
		
		
		boolean messageStatus = controller.receiveMessage(message);
		List<SalesDetail> details= new ArrayList<SalesDetail>(controller.getSalesData().values());
		Assert.assertEquals(0, details.size());
		Assert.assertFalse(messageStatus);
		
	}
	
	@Test
	public void testDisplayTenMessage() {
		Sales sales = new Sales("Apple", 10);
		SalesQuantityMessage quantityMessage = new SalesQuantityMessage(sales, 2);
		SalesAdjustmentMessage adjustmentMessage = new SalesAdjustmentMessage(sales, "ADD");
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(quantityMessage);
		salesMessages.add(adjustmentMessage);
		
		Message message = new Message(salesMessages);
		
		
		Sales sales1 = new Sales("Mango", 25);
		SalesQuantityMessage quantityMessage1 = new SalesQuantityMessage(sales1, 13);
		SalesAdjustmentMessage adjustmentMessage1 = new SalesAdjustmentMessage(sales1, "ADD");
		List<SalesMessage> salesMessages1 = new ArrayList<SalesMessage>();
		salesMessages1.add(quantityMessage1);
		salesMessages1.add(adjustmentMessage1);
		Message message1 = new Message(salesMessages1);
		
		Sales sales2 = new Sales("Kiwi", 3);
		SalesQuantityMessage quantityMessage2 = new SalesQuantityMessage(sales2,21);
		SalesAdjustmentMessage adjustmentMessage2 = new SalesAdjustmentMessage(sales2, "ADD");
		List<SalesMessage> salesMessages2 = new ArrayList<SalesMessage>();
		salesMessages2.add(quantityMessage2);
		salesMessages2.add(adjustmentMessage2);
		Message message2 = new Message(salesMessages2);
		
		Sales sales3 = new Sales("Pinapple", 21);
		SalesQuantityMessage quantityMessage3 = new SalesQuantityMessage(sales3,19);
		SalesAdjustmentMessage adjustmentMessage3 = new SalesAdjustmentMessage(sales3, "ADD");
		List<SalesMessage> salesMessages3 = new ArrayList<SalesMessage>();
		salesMessages3.add(quantityMessage3);
		salesMessages3.add(adjustmentMessage3);
		Message message3 = new Message(salesMessages3);
		
		Sales sales4 = new Sales("Orange", 17);
		SalesQuantityMessage quantityMessage4 = new SalesQuantityMessage(sales4, 41);
		SalesAdjustmentMessage adjustmentMessage4 = new SalesAdjustmentMessage(sales4, "ADD");
		List<SalesMessage> salesMessages4 = new ArrayList<SalesMessage>();
		salesMessages4.add(quantityMessage4);
		salesMessages4.add(adjustmentMessage4);
		Message message4 = new Message(salesMessages4);
		
		Sales sales5 = new Sales("Apricoat", 14);
		SalesQuantityMessage quantityMessage5 = new SalesQuantityMessage(sales5,42);
		SalesAdjustmentMessage adjustmentMessage5 = new SalesAdjustmentMessage(sales5, "ADD");
		List<SalesMessage> salesMessages5 = new ArrayList<SalesMessage>();
		salesMessages5.add(quantityMessage5);
		salesMessages5.add(adjustmentMessage5);
		Message message5 = new Message(salesMessages5);
		
		Sales sales6 = new Sales("Pappaya", 9);
		SalesQuantityMessage quantityMessage6 = new SalesQuantityMessage(sales6, 35);
		SalesAdjustmentMessage adjustmentMessage6 = new SalesAdjustmentMessage(sales6, "ADD");
		List<SalesMessage> salesMessages6 = new ArrayList<SalesMessage>();
		salesMessages6.add(quantityMessage6);
		salesMessages6.add(adjustmentMessage6);
		Message message6 = new Message(salesMessages6);
		
		Sales sales7 = new Sales("Lemon", 14);
		SalesQuantityMessage quantityMessage7 = new SalesQuantityMessage(sales7, 31);
		SalesAdjustmentMessage adjustmentMessage7 = new SalesAdjustmentMessage(sales7, "ADD");
		List<SalesMessage> salesMessages7 = new ArrayList<SalesMessage>();
		salesMessages7.add(quantityMessage7);
		salesMessages7.add(adjustmentMessage7);
		Message message7 = new Message(salesMessages7);
		
		Sales sales8 = new Sales("Banana", 22);
		SalesQuantityMessage quantityMessage8 = new SalesQuantityMessage(sales8, 13);
		SalesAdjustmentMessage adjustmentMessage8 = new SalesAdjustmentMessage(sales8, "ADD");
		List<SalesMessage> salesMessages8 = new ArrayList<SalesMessage>();
		salesMessages8.add(quantityMessage8);
		salesMessages8.add(adjustmentMessage8);
		Message message8 = new Message(salesMessages8);
		
		Sales sales9 = new Sales("Chikoo", 40);
		SalesQuantityMessage quantityMessage9 = new SalesQuantityMessage(sales9, 16);
		SalesAdjustmentMessage adjustmentMessage9 = new SalesAdjustmentMessage(sales, "ADD");
		List<SalesMessage> salesMessages9 = new ArrayList<SalesMessage>();
		salesMessages9.add(quantityMessage9);
		salesMessages9.add(adjustmentMessage9);
		Message message9 = new Message(salesMessages9);
		
		List<Boolean> responses = new ArrayList<Boolean>();
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		Assert.assertEquals(10, responses.size());
		
		for(Boolean isMessageSuccess : responses){
			Assert.assertTrue(isMessageSuccess);
		}
		
		Map<String, SalesDetail> salesMap = controller.getSalesData();
		
		SalesDetail detailApple = salesMap.get("Apple");
		Assert.assertEquals(detailApple.getProductType(), sales.getProductType());
		Assert.assertEquals(40,detailApple.getAmount());
		
		SalesDetail detailChikoo = salesMap.get("Chikoo");
		Assert.assertEquals(detailChikoo.getProductType(), sales9.getProductType());
		Assert.assertEquals(640,detailChikoo.getAmount());
		
		SalesDetail detailBanana = salesMap.get("Banana");
		Assert.assertEquals(detailBanana.getProductType(), sales8.getProductType());
		Assert.assertEquals(572,detailBanana.getAmount());
		
		SalesDetail detailLemon = salesMap.get("Lemon");
		Assert.assertEquals(detailLemon.getProductType(), sales7.getProductType());
		Assert.assertEquals(868,detailLemon.getAmount());
		
		SalesDetail detailPappaya = salesMap.get("Pappaya");
		Assert.assertEquals(detailPappaya.getProductType(), sales6.getProductType());
		Assert.assertEquals(630,detailPappaya.getAmount());
		
		SalesDetail detailApricoat = salesMap.get("Apricoat");
		Assert.assertEquals(detailApricoat.getProductType(), sales5.getProductType());
		Assert.assertEquals(1176,detailApricoat.getAmount());
		
		SalesDetail detailOrange = salesMap.get("Orange");
		Assert.assertEquals(detailOrange.getProductType(), sales4.getProductType());
		Assert.assertEquals(1394,detailOrange.getAmount());
		
		SalesDetail detailPinapple = salesMap.get("Pinapple");
		Assert.assertEquals(detailPinapple.getProductType(), sales3.getProductType());
		Assert.assertEquals(798,detailPinapple.getAmount());
		
		SalesDetail detailKiwi = salesMap.get("Kiwi");
		Assert.assertEquals(detailKiwi.getProductType(), sales2.getProductType());
		Assert.assertEquals(126,detailKiwi.getAmount());
		
		SalesDetail detailMango = salesMap.get("Mango");
		Assert.assertEquals(detailMango.getProductType(), sales1.getProductType());
		Assert.assertEquals(650,detailMango.getAmount());
		
		
	}
	
	@Test
	public void testDisplayFiftyMessage() {
		Sales sales = new Sales("Apple", 10);
		SalesQuantityMessage quantityMessage = new SalesQuantityMessage(sales, 2);
		SalesAdjustmentMessage adjustmentMessage = new SalesAdjustmentMessage(sales, "ADD");
		List<SalesMessage> salesMessages = new ArrayList<SalesMessage>();
		salesMessages.add(quantityMessage);
		salesMessages.add(adjustmentMessage);
		
		Message message = new Message(salesMessages);
		
		
		Sales sales1 = new Sales("Mango", 2);
		SalesQuantityMessage quantityMessage1 = new SalesQuantityMessage(sales1, 1);
		SalesAdjustmentMessage adjustmentMessage1 = new SalesAdjustmentMessage(sales1, "ADD");
		List<SalesMessage> salesMessages1 = new ArrayList<SalesMessage>();
		salesMessages1.add(quantityMessage1);
		salesMessages1.add(adjustmentMessage1);
		Message message1 = new Message(salesMessages1);
		
		Sales sales2 = new Sales("Kiwi", 3);
		SalesQuantityMessage quantityMessage2 = new SalesQuantityMessage(sales2,2);
		SalesAdjustmentMessage adjustmentMessage2 = new SalesAdjustmentMessage(sales2, "ADD");
		List<SalesMessage> salesMessages2 = new ArrayList<SalesMessage>();
		salesMessages2.add(quantityMessage2);
		salesMessages2.add(adjustmentMessage2);
		Message message2 = new Message(salesMessages2);
		
		Sales sales3 = new Sales("Pinapple", 2);
		SalesQuantityMessage quantityMessage3 = new SalesQuantityMessage(sales3,3);
		SalesAdjustmentMessage adjustmentMessage3 = new SalesAdjustmentMessage(sales3, "ADD");
		List<SalesMessage> salesMessages3 = new ArrayList<SalesMessage>();
		salesMessages3.add(quantityMessage3);
		salesMessages3.add(adjustmentMessage3);
		Message message3 = new Message(salesMessages3);
		
		Sales sales4 = new Sales("Orange", 2);
		SalesQuantityMessage quantityMessage4 = new SalesQuantityMessage(sales4, 4);
		SalesAdjustmentMessage adjustmentMessage4 = new SalesAdjustmentMessage(sales4, "ADD");
		List<SalesMessage> salesMessages4 = new ArrayList<SalesMessage>();
		salesMessages4.add(quantityMessage4);
		salesMessages4.add(adjustmentMessage4);
		Message message4 = new Message(salesMessages4);
		
		Sales sales5 = new Sales("Apricoat", 4);
		SalesQuantityMessage quantityMessage5 = new SalesQuantityMessage(sales5,2);
		SalesAdjustmentMessage adjustmentMessage5 = new SalesAdjustmentMessage(sales5, "ADD");
		List<SalesMessage> salesMessages5 = new ArrayList<SalesMessage>();
		salesMessages5.add(quantityMessage5);
		salesMessages5.add(adjustmentMessage5);
		Message message5 = new Message(salesMessages5);
		
		Sales sales6 = new Sales("Pappaya", 9);
		SalesQuantityMessage quantityMessage6 = new SalesQuantityMessage(sales6, 5);
		SalesAdjustmentMessage adjustmentMessage6 = new SalesAdjustmentMessage(sales6, "ADD");
		List<SalesMessage> salesMessages6 = new ArrayList<SalesMessage>();
		salesMessages6.add(quantityMessage6);
		salesMessages6.add(adjustmentMessage6);
		Message message6 = new Message(salesMessages6);
		
		Sales sales7 = new Sales("Lemon", 4);
		SalesQuantityMessage quantityMessage7 = new SalesQuantityMessage(sales7, 1);
		SalesAdjustmentMessage adjustmentMessage7 = new SalesAdjustmentMessage(sales7, "ADD");
		List<SalesMessage> salesMessages7 = new ArrayList<SalesMessage>();
		salesMessages7.add(quantityMessage7);
		salesMessages7.add(adjustmentMessage7);
		Message message7 = new Message(salesMessages7);
		
		Sales sales8 = new Sales("Banana", 2);
		SalesQuantityMessage quantityMessage8 = new SalesQuantityMessage(sales8, 3);
		SalesAdjustmentMessage adjustmentMessage8 = new SalesAdjustmentMessage(sales8, "ADD");
		List<SalesMessage> salesMessages8 = new ArrayList<SalesMessage>();
		salesMessages8.add(quantityMessage8);
		salesMessages8.add(adjustmentMessage8);
		Message message8 = new Message(salesMessages8);
		
		Sales sales9 = new Sales("Chikoo", 4);
		SalesQuantityMessage quantityMessage9 = new SalesQuantityMessage(sales9, 6);
		SalesAdjustmentMessage adjustmentMessage9 = new SalesAdjustmentMessage(sales9, "ADD");
		List<SalesMessage> salesMessages9 = new ArrayList<SalesMessage>();
		salesMessages9.add(quantityMessage9);
		salesMessages9.add(adjustmentMessage9);
		Message message9 = new Message(salesMessages9);
		
		List<Boolean> responses = new ArrayList<Boolean>();
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		responses.add(controller.receiveMessage(message));
		responses.add(controller.receiveMessage(message1));
		responses.add(controller.receiveMessage(message2));
		responses.add(controller.receiveMessage(message3));
		responses.add(controller.receiveMessage(message4));
		responses.add(controller.receiveMessage(message5));
		responses.add(controller.receiveMessage(message6));
		responses.add(controller.receiveMessage(message7));
		responses.add(controller.receiveMessage(message8));
		responses.add(controller.receiveMessage(message9));
		
		Assert.assertEquals(50, responses.size());
		
		for(Boolean isMessageSuccess : responses){
			Assert.assertTrue(isMessageSuccess);
		}
		
	}


}
