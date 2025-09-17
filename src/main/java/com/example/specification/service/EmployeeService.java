package com.example.specification.service;

import com.example.specification.model.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, Integer> {
    List<Employee> selectAll();
}
