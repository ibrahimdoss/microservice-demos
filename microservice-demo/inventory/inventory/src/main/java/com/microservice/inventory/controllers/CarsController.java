package com.microservice.inventory.controllers;

import com.microservice.inventory.service.concretes.CarService;
import com.microservice.inventory.service.dtos.request.CreateCarRequest;
import com.microservice.inventory.service.dtos.response.CreatedCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return  this.carService.add(createCarRequest);
    }
}
