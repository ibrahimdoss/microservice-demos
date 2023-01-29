package com.microservice.inventory.repositories;

import com.microservice.inventory.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, String> {
    boolean existsByNameIgnoreCase(String name);

}
