package com.zandolsi.examples.ms.establishment.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstablishmentRequestDto {

    private String name;
    private Integer stars;
}
