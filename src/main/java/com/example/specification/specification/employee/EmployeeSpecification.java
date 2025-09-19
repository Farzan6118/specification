package com.example.specification.specification.employee;

import com.example.specification.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {


    public static Specification<Employee> hasFirstname(String firstname) {
        return (root, query, cb) ->
                firstname == null ? null : cb.equal(root.get("firstname"), firstname);
    }

    public static Specification<Employee> hasLastname(String lastname) {
        return (root, query, cb) ->
                lastname == null ? null : cb.equal(root.get("lastname"), lastname);
    }

    public static Specification<Employee> hasNationalCode(String nationalCode) {
        return (root, query, cb) ->
                nationalCode == null ? null : cb.equal(root.get("nationalCode"), nationalCode);
    }

    public static Specification<Employee> hasUsername(String username) {
        return (root, query, cb) ->
                username == null ? null : cb.equal(root.get("username"), username);
    }

    public static Specification<Employee> hasPhoneNumber(String phoneNumber) {
        return (root, query, cb) ->
                phoneNumber == null ? null : cb.equal(root.get("phoneNumber"), phoneNumber);
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null : cb.equal(root.get("email"), email);
    }
}