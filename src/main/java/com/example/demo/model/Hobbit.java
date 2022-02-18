package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

// Supermoc: encja JPA
@Entity
public class Hobbit {
    // @Id z pakietu javax, z pakietu spring'owego dla innych typów datasource np. MongoDB
    @Id
    private Long id;
}
