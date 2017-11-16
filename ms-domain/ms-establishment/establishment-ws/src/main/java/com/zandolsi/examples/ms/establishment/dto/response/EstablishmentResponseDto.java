package com.zandolsi.examples.ms.establishment.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstablishmentResponseDto {

    private String id;
    private String name;
    private Integer stars;
}
