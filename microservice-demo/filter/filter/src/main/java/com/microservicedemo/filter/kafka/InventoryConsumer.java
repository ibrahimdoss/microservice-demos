package com.microservicedemo.filter.kafka;

import com.microservice.common.InventoryCreatedEvent;
import com.microservicedemo.filter.models.Inventory;
import com.microservicedemo.filter.service.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryConsumer.class);
    private FilterService filterService;
//topicde ne icin olduğunu belirtiyoruz.
    @KafkaListener(topics = "inventory-car-created",groupId = "inventory-create")
    public void consume(InventoryCreatedEvent inventoryCreatedEvent){
        Inventory inventory = new Inventory();
        inventory.setBrandName(inventoryCreatedEvent.getBrandName());
        inventory.setBrandId(inventoryCreatedEvent.getBrandId());
        inventory.setCarId(inventoryCreatedEvent.getCarId());
        inventory.setModelId(inventoryCreatedEvent.getModelId());
        inventory.setState(inventoryCreatedEvent.getState());
        inventory.setPlate(inventoryCreatedEvent.getPlate());
        inventory.setDailyPrice(inventoryCreatedEvent.getDailyPrice());
        inventory.setModelYear(inventoryCreatedEvent.getModelYear());
        inventory.setModelName(inventoryCreatedEvent.getModelName());

        this.filterService.add(inventory);
    }

    /*
    * Eğer birden fazla event varsa kafka ilgili eventi bellekten atmıyor.
    * Normalde kafka eğer birisi bunu dinlerse bunu kuyruktan atıyor.
    *
    *Ama yukarıdaki groupId ile şunu yapabiliyoruz, bu grupta olanların tamamı dinlemediği sürece
    * bellekten atma demek.
    * Yani servislerin icinde bambaska biri daha bi consumer daha dinliyosa ve ona da aynı groupId verirsek
    * ikisi de dinlemediği sürece kuyruktan atmaz.
    *
    *
    *
    *
    * */
}
