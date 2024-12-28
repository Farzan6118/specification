package com.example.specification.controller;

import com.example.specification.model.Employee;
import com.example.specification.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> selectAll() {
        return ResponseEntity.ok(employeeService.selectAll());
    }

    @GetMapping("orderBySalary")
    public ResponseEntity<List<Employee>> orderBySalary() {
        return ResponseEntity.ok(employeeService.orderBySalary());
    }

    @GetMapping("orderById")
    public ResponseEntity<List<Employee>> orderById() {
        return ResponseEntity.ok(employeeService.orderById());
    }

    @GetMapping("orderByIdBiggerThan5")
    public ResponseEntity<List<Employee>> orderByIdBiggerThan5() {
        return ResponseEntity.ok(employeeService.orderByIdBiggerThan5());
    }


}
