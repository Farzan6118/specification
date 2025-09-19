package com.example.specification.service;

import com.example.specification.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService extends BaseService<Employee, Integer> {

    Page<Employee> search(String firstname, String lastname, String nationalCode
            , Integer page, Integer size, String sortBy, Boolean ascending
    );

}
