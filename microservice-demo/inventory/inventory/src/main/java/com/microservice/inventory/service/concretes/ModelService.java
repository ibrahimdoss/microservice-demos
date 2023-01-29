package com.microservice.inventory.service.concretes;

import com.microservice.inventory.service.dtos.request.CreateModelRequest;
import com.microservice.inventory.service.dtos.response.CreatedModelResponse;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
}
