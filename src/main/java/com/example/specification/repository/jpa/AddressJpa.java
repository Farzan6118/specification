package com.example.specification.repository.jpa;

import com.example.specification.model.Address;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AddressJpa extends BaseJpa<Address, Integer>, JpaSpecificationExecutor<Address> {

    List<Address> findAll(Specification<Address> and);
}
