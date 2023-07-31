package com.practice.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(ConsumerService.class);
    @KafkaListener(topics = "Kafka_Topic", groupId = "kafka_group")
    public void listenToTopic(String receiveMessage){
        LOGGER.info("the message is received is " + receiveMessage);
    }
}
