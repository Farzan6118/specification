package com.example.specification.repository.impl;

import com.example.specification.model.Employee;
import com.example.specification.repository.EmployeeRepository;
import com.example.specification.repository.jpa.EmployeeJpa;
import com.example.specification.specification.SpecificationBuilder;
import com.example.specification.specification.employee.EmployeeSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl
        extends BaseRepositoryImpl<EmployeeJpa, Employee, Integer>
        implements EmployeeRepository {

    public EmployeeRepositoryImpl(EmployeeJpa jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public Page<Employee> search(String firstname, String lastname, String nationalCode,
                                 int page, int size, String sortBy, boolean ascending) {

        Specification<Employee> spec = SpecificationBuilder.<Employee>alwaysTrue()
                .and(EmployeeSpecification.hasFirstname(firstname))
                .and(EmployeeSpecification.hasLastname(lastname))
                .and(EmployeeSpecification.hasNationalCode(nationalCode));

        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return jpaRepository.findAll(spec, pageable);
    }
}