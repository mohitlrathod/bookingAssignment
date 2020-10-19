package com.mohit.booking.model.entity;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.mohit.booking.model.ContainerType;

@Table
public class BookingRequestEntity {
	
	@PrimaryKey()
	@PrimaryKeyColumn(name = "bookingRef", type = PrimaryKeyType.PARTITIONED ,ordering = Ordering.ASCENDING ,ordinal = 11111)
	private long bookingRef;

	private ContainerType containerType;
	
	private String origin;
	
	private String destination;
	
	private int quantity;
	
	private int containerSize;
	
	private String timeStamp;

	public long getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(long bookingRef) {
		this.bookingRef = bookingRef;
	}

	public ContainerType getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
