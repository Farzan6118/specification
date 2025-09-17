package com.example.specification.repository.jpa;

import com.example.specification.model.BaseEntity;
import com.example.specification.model.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BaseJpa<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T,ID> , JpaSpecificationExecutor<T> {

    List<Employee> findAll(Specification<Object> and);
}
