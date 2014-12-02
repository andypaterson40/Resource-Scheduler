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
	
	/**
	 * Main algorithm for prioritizing messages and comparing the current messages' group ID to 
	 * last messages' group ID.
	 * @param messages
	 * @return
	 */
	public Message messagePrioritisationAlgorithm(ConcurrentLinkedQueue<Message> messages) {
		Message msgToSend = null;
		Message msg = messages.peek();
		boolean send = checkMessageGroupIsInQueue(msg.getGroupId(), messages);
		int groupId = 0;
		
		if(send) {
			msgToSend = messages.poll();
			groupId = msgToSend.getGroupId();
		} else {
			Message nextMsg = getNextMessageFromQueue(groupId, messages);
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
	private boolean checkMessageGroupIsInQueue(int groupId, ConcurrentLinkedQueue<Message> messages) {
		for(Message msg : messages) {
			if(groupId == msg.getGroupId()) {
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
		Iterator it = messages.iterator();
		while(it.hasNext()) {
			Message msg = (Message) it.next();
			if(msg.getGroupId() == groupId) {
				return msg;
			}
		}
		return null;
	}

}
