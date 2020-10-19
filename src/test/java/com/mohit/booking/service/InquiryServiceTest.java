package com.mohit.booking.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohit.booking.config.ConfigProperties;
import com.mohit.booking.model.BookingInquiry;
import com.mohit.booking.model.InquiryResponse;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class InquiryServiceTest {
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	ConfigProperties config;
	
	@InjectMocks
	InquiryService inqServiceMock;
	

	@Test
	void givenShipmentDetails_whenSpace_Available() throws IOException {

		String requestJsonName = "inquiryRequest.json";
		
		String request = readJsonFromFile(requestJsonName);
		
		ObjectMapper om = new ObjectMapper();
		BookingInquiry bm = om.readValue(request, BookingInquiry.class);
		
		when(restTemplate.postForObject(config.getUrl(), bm, String.class)).thenReturn("2");;

		InquiryResponse inqResponse  = (InquiryResponse)inqServiceMock.getBookingDetails(bm);
		
		assertTrue(inqResponse.isAvailable());
		
	}

	@Test
	void givenShipmentDetails_whenSpace_NOTAvailable() throws IOException {

		String requestJsonName = "inquiryRequest.json";
		
		String request = readJsonFromFile(requestJsonName);
		
		ObjectMapper om = new ObjectMapper();
		BookingInquiry bm = om.readValue(request, BookingInquiry.class);
		
		when(restTemplate.postForObject(config.getUrl(), bm, String.class)).thenReturn("0");

		InquiryResponse inqResponse  = (InquiryResponse)inqServiceMock.getBookingDetails(bm);
		
		assertFalse(inqResponse.isAvailable());
		
	}

	private String readJsonFromFile(String requestJsonName) throws FileNotFoundException, IOException {
		File file =  ResourceUtils.getFile(
			      "classpath:TestJsons/"+requestJsonName);		 
		String request = new String ( Files.readAllBytes(file.toPath()));
		return request;
	}

}
