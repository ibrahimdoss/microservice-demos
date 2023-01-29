package com.microservice.inventory.service.concretes;

import com.microservice.inventory.service.dtos.request.CreateBrandRequest;
import com.microservice.inventory.service.dtos.response.CreatedBrandResponse;

public interface BrandService {

    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
}
