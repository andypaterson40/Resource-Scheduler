package com.messaging.system;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.messaging.system.impl.GatewayImpl;
import com.messaging.system.impl.MessageImpl;

public class GatewayImplTest {
	
	private Gateway gateway;
	
	@Before
	public void setUp() {
		gateway = new GatewayImpl();
	}
	
	@After
	public void tearDown() {
		gateway = null;
	}
	
	@Test
	public void testSendMessage() {
		Message msg = new MessageImpl(1, 1, Status.PROCESSING);
		gateway.send(msg);
		assertTrue(msg.isMessageCompleted());
	}
}
