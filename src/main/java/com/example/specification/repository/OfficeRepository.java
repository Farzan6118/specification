package com.example.specification.repository;

import com.example.specification.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OfficeRepository extends JpaRepository<Office, Long>, JpaSpecificationExecutor<Office> {

}
