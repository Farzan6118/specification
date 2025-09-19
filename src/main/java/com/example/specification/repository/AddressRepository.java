package com.example.specification.repository;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import org.springframework.data.domain.Page;

public interface AddressRepository extends BaseRepository<Address, Integer> {

    Page<Address> search(
            String city,
            String province,
            String postalCode,
            AddressType type,
            Boolean isDefault,
            int page,
            int size,
            String sortBy,
            boolean ascending
    );
}
