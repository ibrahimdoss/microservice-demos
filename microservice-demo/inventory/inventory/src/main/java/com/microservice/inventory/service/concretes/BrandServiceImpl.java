package com.microservice.inventory.service.concretes;

import com.microservice.common.BrandCreatedEvent;
import com.microservice.inventory.kafka.producers.InventoryProducer;
import com.microservice.inventory.model.Brand;
import com.microservice.inventory.repositories.BrandRepository;
import com.microservice.inventory.service.dtos.request.CreateBrandRequest;
import com.microservice.inventory.service.dtos.response.CreatedBrandResponse;
import com.microservice.inventory.service.rules.BrandServiceRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    private BrandServiceRules brandServiceRules;

    private InventoryProducer inventoryProducer;


    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {

        this.brandServiceRules.checkIfBrandExist(createBrandRequest.getName());

        //Mapping prefer use mapstruct
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());

        brand.setId(UUID.randomUUID().toString());
        Brand createdBrand = brandRepository.save(brand);

        CreatedBrandResponse response = new CreatedBrandResponse();
        response.setId(createdBrand.getId());
        response.setName(createdBrand.getName());

        BrandCreatedEvent event = new BrandCreatedEvent();
        event.setId(createdBrand.getId());
        event.setName(createdBrand.getName());
        inventoryProducer.sendMessage(event);

        return response;
    }
}
