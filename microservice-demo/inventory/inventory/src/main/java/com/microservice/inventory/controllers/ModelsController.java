package com.microservice.inventory.controllers;
import com.microservice.inventory.service.concretes.ModelService;
import com.microservice.inventory.service.dtos.request.CreateModelRequest;
import com.microservice.inventory.service.dtos.response.CreatedModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelsController {
    private ModelService modelService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return  this.modelService.add(createModelRequest);
    }

}