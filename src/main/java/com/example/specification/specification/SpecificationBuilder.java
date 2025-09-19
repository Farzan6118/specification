package com.example.specification.specification;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationBuilder {

    public static <T> Specification<T> alwaysTrue() {
        return (root, query, cb) -> cb.conjunction();
    }
}