package com.microservice.inventory.controllers;

import com.microservice.inventory.service.concretes.BrandService;
import com.microservice.inventory.service.dtos.request.CreateBrandRequest;
import com.microservice.inventory.service.dtos.response.CreatedBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping("/brands/v1")
public class BrandsController {

    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse addBrand(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return this.brandService.add(createBrandRequest);
    }
}
