package com.mohit.booking.model;


public class InquiryResponse implements Response{

	private boolean available;
	
	public InquiryResponse(boolean available) {
		super();
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
