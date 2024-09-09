package com.springbatch.springbatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Organization {
    @Id
    private Long id;
    private String name;
    private String country;
    private int employees;
}
