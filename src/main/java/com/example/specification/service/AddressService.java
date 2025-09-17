package com.example.specification.service;

import com.example.specification.model.Address;

import java.util.List;

public interface AddressService extends BaseService<Address, Integer> {
    List<Address> selectAll();

    List<Address> orderBySalary();

    List<Address> orderById();

    List<Address> orderByIdBiggerThan5();
}
