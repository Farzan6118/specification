package com.example.specification.repository.impl;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import com.example.specification.repository.AddressRepository;
import com.example.specification.repository.jpa.AddressJpa;
import com.example.specification.specification.SpecificationBuilder;
import com.example.specification.specification.address.AddressSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl
        extends BaseRepositoryImpl<AddressJpa, Address, Integer>
        implements AddressRepository {

    public AddressRepositoryImpl(AddressJpa jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public Page<Address> search(
            String city,
            String province,
            String postalCode,
            AddressType type,
            Boolean isDefault,
            int page,
            int size,
            String sortBy,
            boolean ascending
    ) {
        // ایجاد Specification بر اساس فیلترها
        Specification<Address> spec = SpecificationBuilder.<Address>alwaysTrue()
                .and(AddressSpecification.hasCity(city))
                .and(AddressSpecification.hasProvince(province))
                .and(AddressSpecification.hasPostalCode(postalCode))
                .and(AddressSpecification.hasAddressType(type))
                .and(AddressSpecification.isDefault(isDefault));

        // ایجاد Pageable با صفحه، سایز و ترتیب
        Sort sort = Sort.by(ascending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        // اجرای کوئری با Specification و Pageable
        return jpaRepository.findAll(spec, pageable);
    }
}