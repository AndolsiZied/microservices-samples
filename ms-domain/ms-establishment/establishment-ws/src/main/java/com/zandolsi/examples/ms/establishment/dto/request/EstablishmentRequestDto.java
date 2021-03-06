package com.zandolsi.examples.ms.establishment.dto.request;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstablishmentRequestDto {

    private String name;
    private Integer stars;
    private List<TableRequestDto> tables;
}
