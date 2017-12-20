package com.zandolsi.examples.ms.booking.controller;

import com.zandolsi.examples.ms.booking.dto.request.BookingRequestDto;
import com.zandolsi.examples.ms.booking.dto.response.BookingResponseDto;
import com.zandolsi.examples.ms.booking.mapper.BookingRequestMapper;
import com.zandolsi.examples.ms.booking.mapper.BookingResponseMapper;
import com.zandolsi.examples.ms.booking.model.Booking;
import com.zandolsi.examples.ms.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingResponseMapper bookingResponseMapper;
    @Autowired
    private BookingRequestMapper bookingRequestMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookingResponseDto> get(@PathVariable String id) {
        Optional<BookingResponseDto> booking = Optional.ofNullable(bookingResponseMapper.to(bookingService
                .get(id)));
        if (booking.isPresent()) {
            return ResponseEntity.ok(booking.get());
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<BookingResponseDto> save(@RequestBody BookingRequestDto booking) throws URISyntaxException {
        Booking createdBooking = bookingService.save(bookingRequestMapper.to(booking));
        URI newResourceURI = new URI("/api/bookings" + createdBooking.getId());
        return ResponseEntity.created(newResourceURI).body(bookingResponseMapper.to(createdBooking));
    }
}
