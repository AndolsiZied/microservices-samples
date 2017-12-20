package com.zandolsi.examples.ms.user.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@lombok.EqualsAndHashCode(of = {"email"})
@Document(collection = "User")
public class User {

    @Id
    private String email;
    private String phoneNumber;
}
