package com.zandolsi.examples.ms.booking.service;

import com.zandolsi.examples.ms.booking.client.EstablishmentClient;
import com.zandolsi.examples.ms.booking.model.Booking;
import com.zandolsi.examples.ms.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class BookingService {

    @Autowired
    private BookingRepository reservationRepository;
    @Autowired
    private EstablishmentClient establishmentClient;

    public Booking get(String id) {
        return reservationRepository.findOne(id);
    }

    public Booking save(Booking reservation) {
        // 1. updating establishment
        String patch = "[{ \"op\": \"add\", \"path\": \"/tables/"+reservation.getTable()+"/bookings\", \"value\": \"" +
                DateTimeFormatter.ISO_DATE_TIME.format(reservation.getBookingTime()) + "\"}]";
        establishmentClient.patchEstablishment(reservation.getReservationFor(), patch);
        // 2. saving reservation
        return reservationRepository.save(reservation);
    }
}
