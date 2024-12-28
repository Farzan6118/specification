package com.example.specification.controller;

import com.example.specification.model.Employee;
import com.example.specification.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("selectAll")
    public List<Employee> selectAll() {
        logger.info("Select all records");
        return employeeService.selectAll();
    }

    @GetMapping("orderBySalary")
    public List<Employee> orderBySalary() {
        logger.info("Select all records by 'salary' order");
        return employeeService.orderBySalary();
    }

    @GetMapping("orderById")
    public List<Employee> orderById() {
        logger.info("Select all records by 'id' order");
        return employeeService.orderById();
    }

    @GetMapping("orderByIdBiggerThan5")
    public List<Employee> orderByIdBiggerThan5() {
        logger.info("Select all records by 'id' bigger than 5");
        return employeeService.orderByIdBiggerThan5();
    }


}
