package com.zandolsi.examples.ms.user.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    private String email;
    private String phoneNumber;
}
