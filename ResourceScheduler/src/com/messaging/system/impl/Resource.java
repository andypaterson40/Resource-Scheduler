package com.messaging.system.impl;

import com.messaging.system.Gateway;
import com.messaging.system.Message;
import com.messaging.system.Status;

public class Resource {
	
	private String resourceName;
	private Status resourceStatus;
	private boolean available;
	
	public Resource() {
	}
	
	public Resource(String name) {
		this.resourceName = name;
	}
	
	public void setStatus(Status status) {
		this.resourceStatus = status;
		if(!status.equals(Status.IDLE)) {
			this.available = false;
		}
	}
	
	public String getStatus() {
		return this.resourceStatus.getStatus();
	}
	
	public String getResourceName() {
		return this.resourceName;
	}
	
	public boolean isResourceAvailable() {
		return this.available;
	}
	
	public void start(Message msg, Gateway gateway) throws InterruptedException {
		Thread resourceThread = null;
		if(resourceThread == null) {
			resourceThread = new Thread(new ResourceThread(msg, gateway));
		}
		
		if(!resourceThread.isAlive()) {
			resourceThread.start();
			resourceThread.wait(5000);
		}
	}
	
	private class ResourceThread implements Runnable {
		private Message msg;
		private Gateway gateway;
		
		public ResourceThread(Message msg, Gateway gateway) {
			this.msg = msg;
			this.gateway = gateway;
		}
		
		public void run() {
			available = false;
			
			try {
				Thread.sleep(5000);
				if(!msg.isMessageCompleted()) {
					gateway.send(msg);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				 available = true;
			}
		}
	}
}