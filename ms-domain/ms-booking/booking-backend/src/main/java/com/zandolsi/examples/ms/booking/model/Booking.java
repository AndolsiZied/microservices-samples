package com.zandolsi.examples.ms.booking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@lombok.EqualsAndHashCode(of = { "id" })
@Document(collection = "Booking")
public class Booking {

    @Id
    private String id;
    private LocalDateTime bookingTime;
    private String reservationFor;
    private String reservationBy;
}
