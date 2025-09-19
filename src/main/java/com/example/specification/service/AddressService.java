package com.example.specification.service;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import org.springframework.data.domain.Page;

public interface AddressService extends BaseService<Address, Integer> {

    Page<Address> search(String city, String province, String postalCode, AddressType addressType, Boolean isDefault,
                         Integer page, Integer size, String sortBy, boolean ascending);

}
