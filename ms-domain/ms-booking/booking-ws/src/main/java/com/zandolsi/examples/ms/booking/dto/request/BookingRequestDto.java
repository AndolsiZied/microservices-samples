package com.zandolsi.examples.ms.booking.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingRequestDto {

    private String name;
    private Integer stars;
}
