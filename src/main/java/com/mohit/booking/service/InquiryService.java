
package com.mohit.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohit.booking.config.ConfigProperties;
import com.mohit.booking.model.BookingInquiry;
import com.mohit.booking.model.InquiryResponse;
import com.mohit.booking.model.Response;

@Service
public class InquiryService implements BaseService<BookingInquiry> {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ConfigProperties config;
	
	
	public Response getBookingDetails(BookingInquiry booking) {

		String response  =  restTemplate.postForObject(
				config.getUrl(), booking, String.class);
		
		
		
		InquiryResponse inqResponse =  Integer.parseInt(response) > 0 ? new InquiryResponse(true)  :  new InquiryResponse(false);
		
		return inqResponse ;
	}
	
}
