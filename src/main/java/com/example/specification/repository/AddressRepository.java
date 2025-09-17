package com.example.specification.repository;

import com.example.specification.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends BaseRepository<Address, Integer>{

}
