package com.zandolsi.examples.ms.booking.repository;

import com.zandolsi.examples.ms.booking.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {
}
