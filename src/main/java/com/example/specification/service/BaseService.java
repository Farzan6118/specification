package com.example.specification.service;

import com.example.specification.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T entity);

    void delete(T entity);

    Boolean existsById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void saveAll(List<T> entities);

}

