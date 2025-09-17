package com.example.specification.model;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationBuilder {

    public static <T> Specification<T> alwaysTrue() {
        return (root, query, cb) -> cb.conjunction();
    }
}