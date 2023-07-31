package com.practice.kafka.empservice;

import com.practice.kafka.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class EmpProducerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(EmpProducerService.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void saveCreateEmployee(Employee employee){
        LOGGER.info(String.format("Employee created"));
        kafkaTemplate.send("emp_topic",employee);
    }
}