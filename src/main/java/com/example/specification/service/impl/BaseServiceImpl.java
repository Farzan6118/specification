package com.example.specification.service.impl;

import com.example.specification.enums.RecordStatus;
import com.example.specification.model.BaseEntity;
import com.example.specification.repository.BaseRepository;
import com.example.specification.service.BaseService;
import org.apache.coyote.BadRequestException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<U extends BaseRepository<T, ID>,
        T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {

    protected final U repository;

    public BaseServiceImpl(U repository) {
        this.repository = repository;
    }

    public T getById(ID id) throws BadRequestException {
        return repository.getById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        entity.setRecordStatus(RecordStatus.DELETED);
        repository.save(entity);
    }

    @Override
    public Boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveAll(List<T> entities) {
        repository.saveAll(entities);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
