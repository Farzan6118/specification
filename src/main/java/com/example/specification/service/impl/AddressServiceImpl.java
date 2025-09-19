package com.example.specification.service.impl;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import com.example.specification.repository.AddressRepository;
import com.example.specification.service.AddressService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl
        extends BaseServiceImpl<AddressRepository, Address, Integer>
        implements AddressService {

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    public Address getById(Integer id) throws BadRequestException {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(
                        "Address not found with id " + id));
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Address not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Page<Address> search(String city, String province, String postalCode, AddressType addressType,
                                Boolean isDefault, Integer page, Integer size, String sortBy, boolean ascending) {
        return repository.search(city, province, postalCode, addressType, isDefault, page, size, sortBy, ascending);
    }
}