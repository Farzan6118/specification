package com.example.specification.service.impl;

import com.example.specification.model.Employee;
import com.example.specification.repository.EmployeeRepository;
import com.example.specification.service.EmployeeService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeRepository, Employee, Integer> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee getById(Integer id) throws BadRequestException {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(
                        "Employee not found with id " + id));
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Page<Employee> search(String firstname, String lastname, String nationalCode, Integer page
            , Integer size, String sortBy, Boolean ascending) {
        return repository.search(firstname, lastname, nationalCode, page, size, sortBy, ascending);
    }

}