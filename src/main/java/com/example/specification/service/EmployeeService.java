package com.example.specification.service;

import com.example.specification.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectAll();

    List<Employee> orderBySalary();

    List<Employee> orderById();

    List<Employee> orderByIdBiggerThan5();
}
