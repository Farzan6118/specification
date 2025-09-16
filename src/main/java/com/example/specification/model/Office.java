package com.example.specification.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Office extends BaseEntity<Integer> {

    private String address;
    private String name;
    private String floor;

}
