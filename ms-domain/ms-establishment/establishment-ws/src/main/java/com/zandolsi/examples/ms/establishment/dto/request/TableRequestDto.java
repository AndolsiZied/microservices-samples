package com.zandolsi.examples.ms.establishment.dto.request;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TableRequestDto {

    private String code;
    private Integer places;
    private List<String> bookings;
}
