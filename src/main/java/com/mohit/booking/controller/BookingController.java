package com.mohit.booking.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.booking.model.BaseBooking;
import com.mohit.booking.model.BookingInquiry;
import com.mohit.booking.model.BookingRequest;
import com.mohit.booking.model.Response;
import com.mohit.booking.service.BaseService;

@RestController
public class BookingController {
	
	@Autowired
	BaseService<BookingRequest> serviceReq;
	
	@Autowired
	BaseService<BookingInquiry> BookingInquiry;

	
	@PostMapping(path = "/api/booking",consumes = "application/json")
	public ResponseEntity<Response> bookingRequest(@RequestBody BookingRequest booking)
	{		
		
			return new ResponseEntity<Response>(LocateService(booking), HttpStatus.OK);
		
		
	}


	private Response LocateService(BookingRequest booking) {
		if(StringUtils.isBlank(booking.getTimeStamp()))
		{
			return BookingInquiry.getBookingDetails((BookingInquiry) booking);
		}
		else
		{
			return serviceReq.getBookingDetails(booking);
		}
		
	}
	

	
	
}
