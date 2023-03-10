package com.microservice.inventory.service.dtos.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedCarResponse {
    private String id;
    private String modelId;
    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
}

