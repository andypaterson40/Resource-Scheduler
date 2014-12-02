package com.messaging.system.impl;

import com.messaging.system.Message;
import com.messaging.system.Status;

/**
 * Simple implementation of Message
 * 
 * @author Andrew Paterson
 *
 */
public class MessageImpl implements Message {
	
	private int groupId;
	private int messageId;
	private Status status;
	
	public MessageImpl(int messageId, int groupId, Status status) {
		this.messageId = messageId;
		this.groupId = groupId;
		this.status = status;
	}
	
	public int getMessageId() {
		return this.messageId;
	}
	
	public int getGroupId() {
		return this.groupId;
	}
	
	public String getMessageStatus() {
		return this.status.getStatus();
	}
	
	public boolean isMessageProcessed() {
		return true;
	}

	@Override
	public void completed() {
		if(this.getMessageStatus().equals(Status.PROCESSED.getStatus())) {
			System.out.println("Message completed.");
		}
	}
	
	public String toString() {
		return this.messageId + " " + this.groupId + " : " + this.status.toString();
	}
}