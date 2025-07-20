package com.example.messageproducer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.request}")
    private String requestTopic;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(requestTopic, message);
        System.out.println("Producer sent: " + message);
    }

    @KafkaListener(topics = "${kafka.topic.response}", groupId = "group-a")
    public void receiveResponse(String message) {
        System.out.println("Producer received: " + message);
    }
}
