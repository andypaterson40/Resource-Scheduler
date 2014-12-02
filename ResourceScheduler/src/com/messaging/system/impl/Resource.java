package com.messaging.system.impl;

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
}