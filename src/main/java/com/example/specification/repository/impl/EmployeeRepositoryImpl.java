package com.example.specification.repository.impl;

import com.example.specification.model.Employee;
import com.example.specification.model.EmployeeSpecification;
import com.example.specification.model.SpecificationBuilder;
import com.example.specification.repository.EmployeeRepository;
import com.example.specification.repository.jpa.EmployeeJpa;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl
        extends BaseRepositoryImpl<EmployeeJpa, Employee, Integer>
        implements EmployeeRepository {

    public EmployeeRepositoryImpl(EmployeeJpa jpaRepository) {
        super(jpaRepository);
    }
    public List<Employee> search(String firstname, String lastname, String nationalCode) {
        return jpaRepository.findAll(
                (Sort) SpecificationBuilder.alwaysTrue()
                        .and(EmployeeSpecification.hasFirstname(firstname))
                        .and(EmployeeSpecification.hasLastname(lastname))
                        .and(EmployeeSpecification.hasNationalCode(nationalCode))
        );
    }
}