package com.example.specification.repository.impl;

import com.example.specification.model.Address;
import com.example.specification.model.Employee;
import com.example.specification.model.EmployeeSpecification;
import com.example.specification.model.SpecificationBuilder;
import com.example.specification.repository.AddressRepository;
import com.example.specification.repository.jpa.AddressJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl
        extends BaseRepositoryImpl<AddressJpa, Address, Integer>
        implements AddressRepository {

    public AddressRepositoryImpl(AddressJpa jpaRepository) {
        super(jpaRepository);
    }
    public List<Employee> search(String firstname, String lastname, String nationalCode) {
        return jpaRepository.findAll(
                SpecificationBuilder.alwaysTrue()
                        .and(EmployeeSpecification.hasFirstname(firstname))
                        .and(EmployeeSpecification.hasLastname(lastname))
                        .and(EmployeeSpecification.hasNationalCode(nationalCode))
        );
    }
}