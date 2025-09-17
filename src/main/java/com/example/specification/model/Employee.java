package com.example.specification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee extends BaseEntity<Integer> {

    private String firstname;
    private String lastname;
    private String username;
    private LocalDateTime employmentDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> address;
    private String nationalCode;
    private String phoneNumber;
    private BigDecimal salary;
    private String email;

}
