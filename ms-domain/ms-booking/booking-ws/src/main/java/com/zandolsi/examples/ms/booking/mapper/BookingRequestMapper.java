package com.zandolsi.examples.ms.booking.mapper;

import com.zandolsi.examples.ms.booking.dto.request.BookingRequestDto;
import com.zandolsi.examples.ms.booking.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingRequestMapper extends GenericMapper<BookingRequestDto, Booking> {
}
