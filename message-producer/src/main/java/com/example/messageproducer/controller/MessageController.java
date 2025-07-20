package com.example.messageproducer.controller;

import com.example.messageproducer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping(value = "/send", consumes = "text/plain")
    public String send(@RequestBody String message) {
        kafkaService.sendMessage(message);
        return "Message sent: " + message;
    }
}
