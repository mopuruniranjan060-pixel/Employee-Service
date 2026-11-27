package com.niranjan.employeemanagementsystem.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public EmployeeEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeEvent(String employeeJson) {
        kafkaTemplate.send("employee-topic", employeeJson);
    }
}

