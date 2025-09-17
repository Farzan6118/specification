package com.example.specification.service.impl;

import com.example.specification.model.Employee;
import com.example.specification.repository.EmployeeRepository;
import com.example.specification.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeRepository, Employee, Integer> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public List<Employee> selectAll() {
        return repository.findAll();
    }

}