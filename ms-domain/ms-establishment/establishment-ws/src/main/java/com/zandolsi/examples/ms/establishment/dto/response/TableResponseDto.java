package com.zandolsi.examples.ms.establishment.dto.response;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TableResponseDto {

    private String code;
    private Integer places;
    private List<String> bookings;
}
