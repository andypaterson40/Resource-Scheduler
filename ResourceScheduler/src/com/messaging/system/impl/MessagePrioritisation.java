package com.messaging.system.impl;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.messaging.system.Message;

/**
 * This class will deal with prioritizing the messages that are coming in and group them
 * together.
 * 
 * @author Andrew Paterson
 *
 */
public class MessagePrioritisation {
	
	private int lastMsgGroupId = 0;
	
	public MessagePrioritisation() {
	}
	
	/**
	 * Main algorithm for prioritizing messages and comparing the current messages' group ID to 
	 * last messages' group ID.
	 * @param messages
	 * @return
	 */
	public Message messagePrioritisationAlgorithm(ConcurrentLinkedQueue<Message> messages) {
		Message msgToSend = null;
		Message msg = messages.peek();
		boolean send = canSendMessageGroup(msg, lastMsgGroupId, messages,
				checkIfMessageGroupExistsInQueue(msg.getGroupId(), messages));
		
		if(send) {
			msgToSend = messages.poll();
			lastMsgGroupId = msgToSend.getGroupId();
		} else {
			Message nextMsg = getNextMessageFromQueue(lastMsgGroupId, messages);
			if(messages.contains(nextMsg)) {
				msgToSend = nextMsg;
				messages.remove(nextMsg);
			}
		}
		return msgToSend;
	}
	
	/**
	 * Method to check if the message group is in the queue already.
	 * @param groupId
	 * @param messages
	 * @return
	 */
	public boolean canSendMessageGroup(Message message, int lastMessageGroupId, ConcurrentLinkedQueue<Message> messages,
			boolean groupExistsInQueue) {
		for(Message msg : messages) {
			if(msg.getGroupId() == lastMessageGroupId || !groupExistsInQueue) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIfMessageGroupExistsInQueue(int groupId, ConcurrentLinkedQueue<Message> messages) {
		for (Message msg : messages) {
			if(msg.getGroupId() == groupId) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retrieve the next message from the queue.
	 * @param groupId
	 * @param messages
	 * @return
	 */
	private Message getNextMessageFromQueue(int groupId, ConcurrentLinkedQueue<Message> messages) {
		Iterator<Message> it = messages.iterator();
		while(it.hasNext()) {
			Message msg = (Message) it.next();
			if(msg.getGroupId() == groupId) {
				return msg;
			}
		}
		return null;
	}

}
