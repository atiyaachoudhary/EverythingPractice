package com.practice.kafka.controller;

import com.practice.kafka.empservice.EmpProducerService;
import com.practice.kafka.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/employee")
@RestController
public class empController {
    @Autowired
    private EmpProducerService empProducerService;

    @PostMapping(value = "/createEmployee")
    public String sendMessageToKafkaTopic(@RequestBody Employee employee){
        this.empProducerService.saveCreateEmployee(employee);
        return "The message send successfully to topic";
    }
}