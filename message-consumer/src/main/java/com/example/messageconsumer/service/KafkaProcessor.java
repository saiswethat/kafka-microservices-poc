package com.example.messageconsumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProcessor {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.response}")
    private String responseTopic;

    public KafkaProcessor(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "${kafka.topic.request}", groupId = "group-b")
    public void handleMessage(String message) {
        System.out.println("Consumer received: " + message);
        String updated = message + " World";
        kafkaTemplate.send(responseTopic, updated);
        System.out.println("Consumer sent: " + updated);
    }
}
