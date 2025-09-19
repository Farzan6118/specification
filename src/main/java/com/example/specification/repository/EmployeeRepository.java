package com.example.specification.repository;

import com.example.specification.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeRepository extends BaseRepository<Employee, Integer> {

    Page<Employee> search(String firstname, String lastname, String nationalCode,
                          int page, int size, String sortBy, boolean ascending);
}
