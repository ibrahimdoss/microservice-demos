package com.microservice.inventory.service.rules;

import com.microservice.inventory.repositories.ModelRepository;
import com.microservice.inventory.utils.exceptions.Exception;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String name) {
        if (this.modelRepository.existsByNameIgnoreCase(name)){
            throw  new Exception("Model name exists");
        }
    }
}
