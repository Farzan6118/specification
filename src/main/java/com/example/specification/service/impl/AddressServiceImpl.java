package com.example.specification.service.impl;

import com.example.specification.model.Address;
import com.example.specification.repository.AddressRepository;
import com.example.specification.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends BaseServiceImpl<AddressRepository, Address, Integer> implements AddressService {

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    public List<Address> selectAll() {
        return List.of();
    }

    @Override
    public List<Address> orderBySalary() {
        return List.of();
    }

    @Override
    public List<Address> orderById() {
        return List.of();
    }

    @Override
    public List<Address> orderByIdBiggerThan5() {
        return List.of();
    }
}