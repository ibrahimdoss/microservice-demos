package com.microservice.inventory.repositories;

import com.microservice.inventory.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {

    boolean existsByNameIgnoreCase(String name);
}
