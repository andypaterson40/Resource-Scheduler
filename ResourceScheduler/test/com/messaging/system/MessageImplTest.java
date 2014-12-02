package com.messaging.system;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.messaging.system.impl.MessageImpl;

public class MessageImplTest {
	
	private Message message;
	private static final Integer MESSAGE_ID = 1;
	private static final Integer MESSAGE_GROUP_ID = 1;
	private static final Status MESSAGE_STATUS = Status.PROCESSING;
	
	@Before
	public void setUp() {
		message = new MessageImpl(MESSAGE_ID, MESSAGE_GROUP_ID, MESSAGE_STATUS);
	}
	
	@After
	public void tearDown() {
		message = null;
	}
	
	@Test
	public void testGroupId() {
		assertTrue(message.getGroupId() == MESSAGE_GROUP_ID);
	}
	
	@Test
	public void testMessageId() {
		assertTrue(message.getMessageId() == MESSAGE_ID);
	}
	
	@Test
	public void testMessageStatus() {
		assertTrue(message.getMessageStatus().equals(MESSAGE_STATUS.toString()));
	}

}
