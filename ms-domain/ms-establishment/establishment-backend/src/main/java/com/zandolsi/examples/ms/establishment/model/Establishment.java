package com.zandolsi.examples.ms.establishment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@lombok.EqualsAndHashCode(of = { "id" })
@Document(collection = "Establishment")
public class Establishment {

    @Id
    private String id;
    private String name;
    private Integer stars;
    private List<Table> tables;
}
