package com.example.specification.specification.address;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import org.springframework.data.jpa.domain.Specification;

public class AddressSpecification {

    public static Specification<Address> hasCity(String city) {
        return (root, query, cb) ->
                city == null ? null : cb.equal(root.get("city"), city);
    }

    public static Specification<Address> hasProvince(String province) {
        return (root, query, cb) ->
                province == null ? null : cb.equal(root.get("province"), province);
    }

    public static Specification<Address> hasPostalCode(String postalCode) {
        return (root, query, cb) ->
                postalCode == null ? null : cb.equal(root.get("postalCode"), postalCode);
    }

    public static Specification<Address> hasAddressType(AddressType type) {
        return (root, query, cb) ->
                type == null ? null : cb.equal(root.get("addressType"), type);
    }

    public static Specification<Address> isDefault(Boolean isDefault) {
        return (root, query, cb) ->
                isDefault == null ? null : cb.equal(root.get("isDefault"), isDefault);
    }
}