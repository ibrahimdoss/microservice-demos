package com.microservice.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BrandCreatedEvent {

    private String name;
    private String id;
}
