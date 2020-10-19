package com.mohit.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookingInquiry implements BaseBooking {

	@JsonProperty("containerType")
	private ContainerType containerType;
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("destination")
	private String destination;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("containerSize")
	private int containerSize;

	public BookingInquiry(ContainerType containerType, String origin, String destination, int quantity,
			int containerSize) {
		super();
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.containerSize = containerSize;
	}
	
	public BookingInquiry()
	{
		
	}

}
