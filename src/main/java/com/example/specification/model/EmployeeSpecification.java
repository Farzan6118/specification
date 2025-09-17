package com.example.specification.model;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeSpecification {
    public static Specification<Object> hasFirstname(String firstname) {
        return (root, query, cb) -> firstname == null ? cb.conjunction() :
                cb.like(cb.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<Object> hasLastname(String lastname) {
        return (root, query, cb) -> lastname == null ? cb.conjunction() :
                cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }

    public static Specification<Object> hasNationalCode(String nationalCode) {
        return (root, query, cb) -> nationalCode == null ? cb.conjunction() :
                cb.equal(root.get("nationalCode"), nationalCode);
    }

    public Specification<Employee> hasSalaryGreaterThan(BigDecimal salary) {
        return (root, query, cb) -> salary == null ? cb.conjunction() :
                cb.greaterThan(root.get("salary"), salary);
    }

    public Specification<Employee> employedAfter(LocalDateTime date) {
        return (root, query, cb) -> date == null ? cb.conjunction() :
                cb.greaterThan(root.get("employmentDate"), date);
    }

    public Specification<Employee> hasPhoneNumber(String phoneNumber) {
        return (root, query, cb) -> phoneNumber == null ? cb.conjunction() :
                cb.equal(root.get("phoneNumber"), phoneNumber);
    }
}