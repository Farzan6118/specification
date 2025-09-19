package com.example.specification.repository.impl;

import com.example.specification.model.BaseEntity;
import com.example.specification.repository.BaseRepository;
import com.example.specification.repository.jpa.BaseJpa;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<U extends BaseJpa<T, ID>,
        T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T, ID> {

    protected final U jpaRepository;

    public BaseRepositoryImpl(U jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Boolean existsById(ID id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(ID id) {
        if (!jpaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public T getById(ID id) {
        return jpaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<T> findAll() {
        List<T> entities = jpaRepository.findAll();
        if (entities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return entities;
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }

    @Override
    public void saveAll(List<T> entities) {
        jpaRepository.saveAll(entities);
    }
}
