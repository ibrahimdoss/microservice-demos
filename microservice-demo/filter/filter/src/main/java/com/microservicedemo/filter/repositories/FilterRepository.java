package com.microservicedemo.filter.repositories;

import com.microservicedemo.filter.models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Inventory, String> {
}
