package com.microservice.inventory.service.concretes;

import com.microservice.inventory.model.Brand;
import com.microservice.inventory.model.Model;
import com.microservice.inventory.repositories.ModelRepository;
import com.microservice.inventory.service.dtos.request.CreateModelRequest;
import com.microservice.inventory.service.dtos.response.CreatedModelResponse;
import com.microservice.inventory.service.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelBusinessRules modelBusinessRules;
    private ModelRepository modelRepository;
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());

        Model model = new Model();
        model.setId(UUID.randomUUID().toString());
        model.setName(createModelRequest.getName());

        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());

        model.setBrand(brand);

        Model createdModel = this.modelRepository.save(model);

        CreatedModelResponse response = new CreatedModelResponse();
        response.setId(createdModel.getId());
        response.setName(createdModel.getName());
        response.setBrandId(createdModel.getBrand().getId());
        return response;
    }
}
