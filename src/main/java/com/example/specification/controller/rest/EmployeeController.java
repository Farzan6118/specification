package com.example.specification.controller.rest;

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

}
