package com.messaging.system;

/**
 * Enum class to handle all enums to be used across all resources and messages.
 * 
 * @author Andrew Paterson
 *
 */
public enum Status {
	
	PENDING("pending"),
	PROCESSING("processing"),
	PROCESSED("processed"),
	IDLE("idle"),
	TERMINATE("terminate");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
