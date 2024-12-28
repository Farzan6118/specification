package com.example.specification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64)
    private String firstName;
    @Column(length = 64)
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contact;
    @Column(length = 16)
    private String nationalCode;
    private String email;
    private BigDecimal salary;

    @ManyToOne
    private Office office;

}
