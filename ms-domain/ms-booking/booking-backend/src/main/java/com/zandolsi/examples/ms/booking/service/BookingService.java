package com.zandolsi.examples.ms.booking.service;

import com.zandolsi.examples.ms.booking.model.Booking;
import com.zandolsi.examples.ms.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository reservationRepository;

    public Booking get(String id) {
        return reservationRepository.findOne(id);
    }

    public Booking save(Booking reservation) {
        return reservationRepository.save(reservation);
    }
}
