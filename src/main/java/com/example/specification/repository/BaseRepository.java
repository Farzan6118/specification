package com.example.specification.repository;


import com.example.specification.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T entity);

    void saveAll(List<T> entities);

    Boolean existsById(ID id);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    T getById(ID id);

    List<T> findAll();

    long count();
}

