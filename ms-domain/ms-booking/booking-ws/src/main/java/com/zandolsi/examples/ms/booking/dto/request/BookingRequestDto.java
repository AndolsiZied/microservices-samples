package com.zandolsi.examples.ms.booking.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingRequestDto {

    private LocalDateTime bookingTime;
    private String reservationFor;
    private String reservationBy;
    private String table;
}
