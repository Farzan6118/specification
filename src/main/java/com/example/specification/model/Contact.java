package com.example.specification.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contact extends BaseEntity<Integer> {

    private String address;
    private String country;
    private String city;
    private String block;
    private String telephone;
    private boolean isDefault;


}
