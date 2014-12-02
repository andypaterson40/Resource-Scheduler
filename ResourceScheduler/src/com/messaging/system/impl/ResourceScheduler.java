package com.messaging.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.messaging.system.Message;
import com.messaging.system.Status;

/**
 * This is the main class which undertakes the main engine work to schedule resources to process
 * messages incoming from the Gateway.
 * 
 * @author Andrew Paterson
 *
 */
public class ResourceScheduler {
	
	private ConcurrentLinkedQueue<Message> messageQueue;
	
	private List<Resource> availableResources = new ArrayList<Resource>();
	
	private Thread scheduler;
	
	public void start() {
		
	}
	
	
	public int numberOfAvailableResources(List<Resource> resources) {
		int available = 0;
		int currentResourceSize = resources.size();
		if(currentResourceSize == 0) {
			return available;
		}
		
		for(int i = 0; i < currentResourceSize; i++) {
			if(resources.get(i).getStatus().equalsIgnoreCase(Status.IDLE.getStatus())) {
				availableResources.add(resources.get(i));
				available++;
			}
		}
		return available;
	}
	
	class Scheduler implements Runnable {

		@Override
		public void run() {
			while(true) {
				
			}
		}
		
	}

}
