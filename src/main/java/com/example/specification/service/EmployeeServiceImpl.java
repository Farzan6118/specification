package com.example.specification.service;

import com.example.specification.model.Employee;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final CriteriaQuery<Employee> criteriaQuery;
    private final CriteriaQuery<Employee> select;
    private final Root<Employee> from;

    public EmployeeServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        from = criteriaQuery.from(Employee.class);
        select = criteriaQuery.select(from);
    }

    public List<Employee> getAll() {
        return orderById();
    }

    @Override
    public List<Employee> selectAll() {
        //select all records
        TypedQuery<Employee> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public List<Employee> orderBySalary() {
        //Ordering the records
        CriteriaQuery<Employee> select1 = criteriaQuery.select(from);
        select1.orderBy(criteriaBuilder.asc(from.get("salary")));
        TypedQuery<Employee> typedQuery1 = entityManager.createQuery(select);
        return typedQuery1.getResultList();
    }

    @Override
    public List<Employee> orderById() {
        //Ordering the records
        CriteriaQuery<Employee> select1 = criteriaQuery.select(from);
        select1.orderBy(criteriaBuilder.asc(from.get("id")));
        TypedQuery<Employee> typedQuery1 = entityManager.createQuery(select);
        return typedQuery1.getResultList();
    }

    @Override
    public List<Employee> orderByIdBiggerThan5() {
        //Ordering the records
        CriteriaQuery<Employee> select1 = criteriaQuery.select(from).where(criteriaBuilder.gt(from.get("id"), 5));
        TypedQuery<Employee> typedQuery1 = entityManager.createQuery(select1);
        return typedQuery1.getResultList();
    }

    @PreDestroy
    private void closeEntityManager() {
        entityManager.close();
    }
}