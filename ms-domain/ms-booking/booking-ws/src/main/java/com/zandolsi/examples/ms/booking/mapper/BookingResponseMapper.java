package com.zandolsi.examples.ms.booking.mapper;

import com.zandolsi.examples.ms.booking.dto.response.BookingResponseDto;
import com.zandolsi.examples.ms.booking.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingResponseMapper extends GenericMapper<Booking, BookingResponseDto> {
}
