package com.practice.kafka.empservice;

import com.practice.kafka.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class EmpConsumerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(EmpConsumerService.class);

    @KafkaListener(topics = "emp_topic", groupId = "emp_group")
    public void consumeMessagesFromTopic(Employee employee){
        LOGGER.info(String.format("Employee created -> %s", employee));
    }
}