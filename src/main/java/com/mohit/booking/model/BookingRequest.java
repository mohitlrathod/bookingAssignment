package com.mohit.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class BookingRequest  extends BookingInquiry {

	private String timeStamp;

	public BookingRequest() {

	}

}
