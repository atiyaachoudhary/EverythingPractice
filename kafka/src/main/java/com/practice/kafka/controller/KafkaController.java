package com.practice.kafka.controller;

import com.practice.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/producerMessage")
    public String getMessageFromClient(@RequestParam("message") String message){
        this.producerService.sendMessageToTopic(message);
        return "Message sent successfully to the topic";
    }
}