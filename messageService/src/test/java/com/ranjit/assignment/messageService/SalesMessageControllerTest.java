package com.ranjit.assignment.messageService;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.assignment.messageService.controller.SalesMessageController;
import com.assignment.messageService.vo.Sales;
import com.assignment.messageService.vo.SalesAdjustment;
import com.assignment.messageService.vo.SalesQuantity;

public class SalesMessageControllerTest {
	
	private SalesMessageController controller;

	@Before
	public void setUp() throws Exception {
		controller=new SalesMessageController();
	}
	
	@Test(expected= RuntimeException.class)
	public void testNullMessage() {
		controller.reciveMessage(null);
	}
	
	@Test
	public void testTenSuccessMessage() {
		List<Boolean> successList = new ArrayList<Boolean>();
		Sales sales1 = new Sales("Apple",10);
		Sales sales2 = new Sales("Mango",10);
		Sales sales3 = new Sales("Kiwi",10);
		Sales sales4 = new Sales("Pinapple",10);
		Sales sales5 = new Sales("Orange",10);
		Sales sales6 = new Sales("Papaya",10);
		Sales sales7 = new Sales("WaterMelon",10);
		Sales sales8 = new Sales("Melon",10);
		Sales sales9 = new Sales("Berrys",10);
		Sales sales10 = new Sales("Guava",10);
		
		successList.add(controller.reciveMessage(sales1));
		successList.add(controller.reciveMessage(sales2));
		successList.add(controller.reciveMessage(sales3));
		successList.add(controller.reciveMessage(sales4));
		successList.add(controller.reciveMessage(sales5));
		successList.add(controller.reciveMessage(sales6));
		successList.add(controller.reciveMessage(sales7));
		successList.add(controller.reciveMessage(sales8));
		successList.add(controller.reciveMessage(sales9));
		successList.add(controller.reciveMessage(sales10));
		
		//All messages are processed
		Assert.assertEquals(10, successList.size());
		
		//All are success
		for(Boolean status:successList){
			Assert.assertTrue(status);
		}
		
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testFailureMessage() {
		
		Sales sales1 = new Sales("Apple",10);
		Sales sales2 = new Sales("Mango",10);
		Sales sales3 = new Sales("Kiwi",10);
		Sales sales4 = new Sales("Pinapple",10);
		Sales sales5 = new Sales("Orange",10);
		Sales sales6 = new Sales("Papaya",10);
		Sales sales7 = new Sales("WaterMelon",10);
		Sales sales8 = new Sales("Melon",10);
		Sales sales9 = new Sales("Berrys",10);
		Sales sales10 = new Sales("Guava",10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
	}

	@Test
	public void testReciveMessage() {
		Sales sales1 = new Sales("Apple",10);
		Sales sales2 = new Sales("Mango",10);
		Sales sales3 = new Sales("Kiwi",10);
		Sales sales4 = new Sales("Pinapple",10);
		Sales sales5 = new Sales("Orange",10);
		Sales sales6 = new Sales("Papaya",10);
		Sales sales7 = new Sales("WaterMelon",10);
		Sales sales8 = new Sales("Melon",10);
		Sales sales9 = new Sales("Berrys",10);
		Sales sales10 = new Sales("Guava",10);
		
		SalesQuantity quantity1 = new SalesQuantity();
		quantity1.setSales(sales1);
		quantity1.setQuantity(2);
		
		SalesQuantity quantity2 = new SalesQuantity();
		quantity2.setSales(sales2);
		quantity2.setQuantity(5);
		
		SalesQuantity quantity3 = new SalesQuantity();
		quantity3.setSales(sales3);
		quantity3.setQuantity(4);
		
		SalesQuantity quantity4 = new SalesQuantity();
		quantity4.setSales(sales4);
		quantity4.setQuantity(4);
		
		SalesQuantity quantity5 = new SalesQuantity();
		quantity5.setSales(sales5);
		quantity5.setQuantity(5);
		
		SalesQuantity quantity6 = new SalesQuantity();
		quantity6.setSales(sales6);
		quantity6.setQuantity(6);
		
		SalesQuantity quantity7 = new SalesQuantity();
		quantity7.setSales(sales7);
		quantity7.setQuantity(7);
		
		SalesQuantity quantity8 = new SalesQuantity();
		quantity8.setSales(sales8);
		quantity8.setQuantity(8);
		
		SalesQuantity quantity9 = new SalesQuantity();
		quantity9.setSales(sales9);
		quantity9.setQuantity(9);
		
		SalesQuantity quantity10 = new SalesQuantity();
		quantity10.setSales(sales10);
		quantity10.setQuantity(10);
		
		SalesAdjustment adjustment1 = new SalesAdjustment();
		adjustment1.setAdjustmentOperation("ADD");
		adjustment1.setSales(sales1);
		
		SalesAdjustment adjustment2 = new SalesAdjustment();
		adjustment2.setAdjustmentOperation("SUBTRACT");
		adjustment2.setSales(sales2);
		
		SalesAdjustment adjustment3 = new SalesAdjustment();
		adjustment3.setAdjustmentOperation("MULTIPLY");
		adjustment3.setSales(sales3);
		
		SalesAdjustment adjustment4 = new SalesAdjustment();
		adjustment4.setAdjustmentOperation("ADD");
		adjustment4.setSales(sales4);
		
		SalesAdjustment adjustment5 = new SalesAdjustment();
		adjustment5.setAdjustmentOperation("MULTIPLY");
		adjustment5.setSales(sales5);
		
		SalesAdjustment adjustment6 = new SalesAdjustment();
		adjustment6.setAdjustmentOperation("ADD");
		adjustment6.setSales(sales6);
		
		SalesAdjustment adjustment7 = new SalesAdjustment();
		adjustment7.setAdjustmentOperation("SUBTRACT");
		adjustment7.setSales(sales7);
		
		SalesAdjustment adjustment8 = new SalesAdjustment();
		adjustment8.setAdjustmentOperation("MULTIPLY");
		adjustment8.setSales(sales8);
		
		SalesAdjustment adjustment9 = new SalesAdjustment();
		adjustment9.setAdjustmentOperation("SUBTRACT");
		adjustment9.setSales(sales9);
		
		SalesAdjustment adjustment10 = new SalesAdjustment();
		adjustment10.setAdjustmentOperation("ADD");
		adjustment10.setSales(sales10);
		
		
		
		
		
		
		SalesAdjustment adjustment11 = new SalesAdjustment();
		adjustment11.setAdjustmentOperation("SUBTRACT");
		adjustment11.setSales(sales1);
		
		SalesAdjustment adjustment12 = new SalesAdjustment();
		adjustment12.setAdjustmentOperation("MULTIPLY");
		adjustment12.setSales(sales2);
		
		SalesAdjustment adjustment13 = new SalesAdjustment();
		adjustment13.setAdjustmentOperation("ADD");
		adjustment13.setSales(sales3);
		
		SalesAdjustment adjustment14 = new SalesAdjustment();
		adjustment14.setAdjustmentOperation("MULTIPLY");
		adjustment14.setSales(sales4);
		
		SalesAdjustment adjustment15 = new SalesAdjustment();
		adjustment15.setAdjustmentOperation("SUBTRACT");
		adjustment15.setSales(sales5);
		
		SalesAdjustment adjustment16 = new SalesAdjustment();
		adjustment16.setAdjustmentOperation("ADD");
		adjustment16.setSales(sales6);
		
		SalesAdjustment adjustment17 = new SalesAdjustment();
		adjustment17.setAdjustmentOperation("SUBTRACT");
		adjustment17.setSales(sales7);
		
		SalesAdjustment adjustment18 = new SalesAdjustment();
		adjustment18.setAdjustmentOperation("MULTIPLY");
		adjustment18.setSales(sales8);
		
		SalesAdjustment adjustment19 = new SalesAdjustment();
		adjustment19.setAdjustmentOperation("ADD");
		adjustment19.setSales(sales9);
		
		SalesAdjustment adjustment20 = new SalesAdjustment();
		adjustment20.setAdjustmentOperation("SUBTRACT");
		adjustment20.setSales(sales10);
		
		
		
		
		
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		controller.reciveMessage(quantity1);
		controller.reciveMessage(quantity2);
		controller.reciveMessage(quantity3);
		controller.reciveMessage(quantity4);
		controller.reciveMessage(quantity5);
		controller.reciveMessage(quantity6);
		controller.reciveMessage(quantity7);
		controller.reciveMessage(quantity8);
		controller.reciveMessage(quantity9);
		controller.reciveMessage(quantity10);
		
		controller.reciveMessage(adjustment1);
		controller.reciveMessage(adjustment2);
		controller.reciveMessage(adjustment3);
		controller.reciveMessage(adjustment4);
		controller.reciveMessage(adjustment5);
		controller.reciveMessage(adjustment6);
		controller.reciveMessage(adjustment7);
		controller.reciveMessage(adjustment8);
		controller.reciveMessage(adjustment9);
		controller.reciveMessage(adjustment10);
		
		controller.reciveMessage(adjustment11);
		controller.reciveMessage(adjustment12);
		controller.reciveMessage(adjustment13);
		controller.reciveMessage(adjustment14);
		controller.reciveMessage(adjustment15);
		controller.reciveMessage(adjustment16);
		controller.reciveMessage(adjustment17);
		controller.reciveMessage(adjustment18);
		controller.reciveMessage(adjustment19);
		controller.reciveMessage(adjustment20);
		
		
		controller.reciveMessage(sales1);
		controller.reciveMessage(sales2);
		controller.reciveMessage(sales3);
		controller.reciveMessage(sales4);
		controller.reciveMessage(sales5);
		controller.reciveMessage(sales6);
		controller.reciveMessage(sales7);
		controller.reciveMessage(sales8);
		controller.reciveMessage(sales9);
		controller.reciveMessage(sales10);
		
		
	}

}
