package com.microservice.inventory.service.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedModelResponse {
    private String id;
    private String name;
    private String brandId;
}
