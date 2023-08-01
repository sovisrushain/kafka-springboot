package com.rechargeservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rechargeservice.dto.Pkg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Value("${topic.name}")
    private String msgTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Pkg pkg) throws JsonProcessingException {
        String rechargeMsg = objectMapper.writeValueAsString(pkg);
        kafkaTemplate.send(msgTopic, rechargeMsg);
        return "SUCCESS";
    }

}
