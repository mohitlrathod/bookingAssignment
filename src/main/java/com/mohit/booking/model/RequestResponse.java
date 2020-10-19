package com.mohit.booking.model;

public class RequestResponse implements Response {

	private String bookingRef;

	public RequestResponse(long bookingRef2) {
		// TODO Auto-generated constructor stub
	}

	public RequestResponse() {
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

}
