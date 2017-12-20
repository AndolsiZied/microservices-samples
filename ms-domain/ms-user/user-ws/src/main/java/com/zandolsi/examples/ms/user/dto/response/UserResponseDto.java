package com.zandolsi.examples.ms.user.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private String email;
    private String phoneNumber;
}
