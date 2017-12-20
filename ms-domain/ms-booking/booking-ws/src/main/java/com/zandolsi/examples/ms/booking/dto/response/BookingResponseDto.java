package com.zandolsi.examples.ms.booking.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingResponseDto {

    private String id;
    private String name;
    private Integer stars;
}
