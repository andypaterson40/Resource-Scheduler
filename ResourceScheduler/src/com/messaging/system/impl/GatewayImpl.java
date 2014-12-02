package com.messaging.system.impl;

import com.messaging.system.Gateway;
import com.messaging.system.Message;

/**
 * Gateway class to send messages to the resources.
 * 
 * @author Andrew Paterson
 *
 */
public class GatewayImpl implements Gateway {

	@Override
	public void send(Message m) {
		if(m.isMessageProcessed()) {
			m.completed();
		}
	}

}
