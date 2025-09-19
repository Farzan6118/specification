package com.example.specification.specification.employee;

import com.example.specification.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasFirstname(String firstname) {
        return (root, query, cb) ->
                firstname == null ? null : cb.like(cb.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<Employee> hasLastname(String lastname) {
        return (root, query, cb) ->
                lastname == null ? null : cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }

    public static Specification<Employee> hasNationalCode(String nationalCode) {
        return (root, query, cb) ->
                nationalCode == null ? null : cb.like(cb.lower(root.get("nationalCode")), "%" + nationalCode.toLowerCase() + "%");
    }

    public static Specification<Employee> hasUsername(String username) {
        return (root, query, cb) ->
                username == null ? null : cb.like(cb.lower(root.get("username")), "%" + username.toLowerCase() + "%");
    }

    public static Specification<Employee> hasPhoneNumber(String phoneNumber) {
        return (root, query, cb) ->
                phoneNumber == null ? null : cb.like(cb.lower(root.get("phoneNumber")), "%" + phoneNumber.toLowerCase() + "%");
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null : cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }
}