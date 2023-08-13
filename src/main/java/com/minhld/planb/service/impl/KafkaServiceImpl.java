package com.minhld.planb.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.minhld.planb.model.InputMessage;
import com.minhld.planb.service.KafkaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaServiceImpl implements KafkaService {
    @Value("spring.kafka.topic")
    String kafkaTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(InputMessage inputMessage) {
        String msg = writeToString(inputMessage);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopicName, msg).completable();
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + msg + "] " +
                        "with offset=[" + result + "]");
            } else {
                System.out.println("Unable to send message=[" + msg + "] " +
                        "due to : " + ex);
            }
        });
        kafkaTemplate.send(kafkaTopicName, msg);
    }

    @SneakyThrows
    String writeToString(InputMessage inputMessage) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(inputMessage);
    }
}
