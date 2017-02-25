//package com.ranjit.assignment.messageService;
//
//import junit.framework.Assert;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.assignment.messageService.component.MessageQueue;
//import com.assignment.messageService.exception.MessageQueueBrokenException;
//import com.assignment.messageService.exception.MessageQueueFullException;
//
//public class MessageQueueTest {
//	
//	private MessageQueue msgQueue;
//
//	@Before
//	public void setUp() throws Exception {
//		msgQueue = new MessageQueue();
//	}
//
//	
//	@Test(expected = RuntimeException.class)
//	public void testNullMessagePut() {
//		try {
//			msgQueue.put(null);
//		} catch (MessageQueueBrokenException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testSuccessMessagePut() {
//		try {
//			boolean messageStatus = msgQueue.put("Test");
//			Assert.assertEquals(true, messageStatus);
//		} catch (MessageQueueBrokenException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testTenMessagePut() {
//		for(int i=1;i<=10;i++){
//			try {
//				msgQueue.put("Test"+i);
//			} catch (MessageQueueBrokenException e) {
//				e.printStackTrace();
//			}
//		}
//		Assert.assertEquals(10, msgQueue.getSize());
//	}
//	
//	@Test
//	public void testFiftyMessagePut() {
//		for(int i=1;i<=50;i++){
//			try {
//				msgQueue.put("Test"+i);
//			} catch (MessageQueueBrokenException e) {
//				e.printStackTrace();
//			}
//		}
//		Assert.assertEquals(50, msgQueue.getSize());
//	}
//	
//	@Test(expected=MessageQueueFullException.class)
//	public void testMoreThanFiftyMessagePut() {
//		for(int i=1;i<=51;i++){
//			try {
//				msgQueue.put("Test"+i);
//			} catch (MessageQueueBrokenException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//}
