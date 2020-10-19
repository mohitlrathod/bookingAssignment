package com.mohit.booking.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.booking.model.BookingRequest;
import com.mohit.booking.model.RequestResponse;
import com.mohit.booking.model.Response;
import com.mohit.booking.model.entity.BookingRequestEntity;
import com.mohit.booking.repository.BookingRequestRepository;

import reactor.core.publisher.Mono;

@Service
public class RequestService implements BaseService<BookingRequest>  {
	
	
	@Autowired
	BookingRequestRepository bookingRequestRepository;

	@Override
	public Response getBookingDetails(BookingRequest bookingRequest) {

		ModelMapper modelMapper = new ModelMapper();
		BookingRequestEntity bookingRequestEntity = modelMapper.map(bookingRequest, BookingRequestEntity.class);
		
		 BookingRequestEntity str = bookingRequestRepository.save(bookingRequestEntity);
		
		return new RequestResponse( str.getBookingRef());
	}



}
