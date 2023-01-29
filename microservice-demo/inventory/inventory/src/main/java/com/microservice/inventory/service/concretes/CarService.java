package com.microservice.inventory.service.concretes;

import com.microservice.inventory.service.dtos.request.CreateCarRequest;
import com.microservice.inventory.service.dtos.response.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);

}
