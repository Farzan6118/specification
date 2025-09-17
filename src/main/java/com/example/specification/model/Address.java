package com.example.specification.model;

import com.example.specification.enums.AddressType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseEntity<Integer> {

    private String name;
    private String title;
    private String country;
    private String province;
    private String city;
    private String street;
    private Integer floor;
    private Integer buildingNumber;
    private Integer unitNumber;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private Boolean isDefault;
    private String postalCode;

}
