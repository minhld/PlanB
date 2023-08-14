package com.minhld.planb.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.minhld.planb.model.InputMessage;
import com.minhld.planb.service.KafkaService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {
    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Value("${spring.kafka.consumer.group-id}")
    String kafkaGroupId;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(InputMessage inputMessage) {
        String msg = writeToString(inputMessage);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopic, msg).completable();
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message to topic {} with offset {}", kafkaTopic, result);
            } else {
                log.error("Unable to send message {} to topic {} due to error {}", msg, kafkaTopic, ex);
            }
        });
    }

    @KafkaListener(topics = "#{'${spring.kafka.topic}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void listener(String message) {
        log.info("Received Message: {} in group {}", message, kafkaGroupId);
    }

    @SneakyThrows
    String writeToString(InputMessage inputMessage) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(inputMessage);
    }
}
