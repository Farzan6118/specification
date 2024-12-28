package com.example.specification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Office extends BaseEntity {

    private String address;
    private String name;
    private String floor;

}
