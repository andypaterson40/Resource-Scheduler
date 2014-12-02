package com.messaging.system;

/**
 * This interface represents the final gateway before the external resource processes the message.
 * 
 * @author Andrew Paterson
 *
 */
public interface Gateway {
	
	/**
	 * 
	 * @param m
	 */
	public void send(Message m);

}
