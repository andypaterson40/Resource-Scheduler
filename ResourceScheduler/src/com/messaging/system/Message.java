package com.messaging.system;

/**
 * This interface represents a single message that is to be sent to the Gateway.
 * 
 * @author Andrew Paterson
 *
 */
public interface Message {
	
	public void completed();
	
	public int getGroupId();
	
	public int getMessageId();
	
	public String getMessageStatus();

	public boolean isMessageCompleted();
}
