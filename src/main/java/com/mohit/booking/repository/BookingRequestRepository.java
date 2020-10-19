package com.mohit.booking.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.repository.CrudRepository;

import com.mohit.booking.model.entity.BookingRequestEntity;

public interface BookingRequestRepository extends CrudRepository<BookingRequestEntity, Long> {
    
	
}
