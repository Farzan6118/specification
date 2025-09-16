package com.example.specification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee extends BaseEntity<Integer> {

    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contact;
    private String nationalCode;
    private String email;
    private BigDecimal salary;
    @ManyToOne
    private Office office;

}
