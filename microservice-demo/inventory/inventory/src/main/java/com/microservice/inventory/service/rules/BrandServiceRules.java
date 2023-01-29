package com.microservice.inventory.service.rules;

import com.microservice.inventory.repositories.BrandRepository;
import com.microservice.inventory.utils.exceptions.Exception;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandServiceRules {

    private BrandRepository brandRepository;

    public void checkIfBrandExist(String name){
        if(this.brandRepository.existsByNameIgnoreCase(name)){
            throw new Exception("Brand already exist");
        }
    }

}
