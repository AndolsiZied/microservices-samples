package com.zandolsi.examples.ms.establishment.model;

import lombok.Data;

import java.util.List;

@Data
public class Table {

    private String code;
    private Integer places;
    private List<String> bookings;
}
