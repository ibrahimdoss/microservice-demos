package com.microservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCreatedEvent {

    private String carId;

    private String modelId;

    private String brandId;

    private String modelName;

    private String brandName;

    private double dailyPrice;

    private int modelYear;

    private String plate;

    private int state;

}
