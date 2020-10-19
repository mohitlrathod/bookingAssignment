package com.mohit.booking.service;

import org.springframework.stereotype.Service;

import com.mohit.booking.model.Response;

@Service
public interface BaseService<T> {

	
	public Response getBookingDetails(T t);
	
}
