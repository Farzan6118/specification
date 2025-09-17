package com.example.specification.repository;


import com.example.specification.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable>{

    T save(T entity);
    void saveAll(List<T> entities);
    Boolean existsById(ID id);
    Optional<T> findById(ID id);
    Page<T> findAll(PageRequest pageRequest);
    List<T> findAll();
}

