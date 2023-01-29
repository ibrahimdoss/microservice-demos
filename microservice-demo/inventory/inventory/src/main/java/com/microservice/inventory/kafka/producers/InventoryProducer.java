package com.microservice.inventory.kafka.producers;

import com.microservice.common.BrandCreatedEvent;
import com.microservice.common.InventoryCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducer {

    private static  final Logger logger = LoggerFactory.getLogger(InventoryProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public InventoryProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Object message) {
        logger.info("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }

    public void sendMessage(BrandCreatedEvent event) {

        logger.info(String.format("Brand added => %s" , event.toString()));

        Message<BrandCreatedEvent> message =
                MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, "inventory-brand-created").build();

        kafkaTemplate.send(message);
    }

    public void sendMessage(InventoryCreatedEvent event){
        logger.info(String.format("Inventory created => %s",event.toString()));

        Message<InventoryCreatedEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,"inventory-car-created")
                .build();

        kafkaTemplate.send(message);
    }

}
