package com.microservice.inventory.repositories;

import com.microservice.inventory.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {

}
