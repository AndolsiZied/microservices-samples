package com.zandolsi.examples.ms.booking.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingResponseDto {

    private LocalDateTime bookingTime;
    private String reservationFor;
    private String reservationBy;
    private String table;
}
