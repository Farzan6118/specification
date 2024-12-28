package com.example.specification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {


    @Column(length = 256)
    private String address;
    @Column(length = 64)
    private String country;
    @Column(length = 64)
    private String city;
    @Column(length = 8)
    private String block;
    @Column(length = 16)
    private String telephone;
    private boolean isDefault;


}
