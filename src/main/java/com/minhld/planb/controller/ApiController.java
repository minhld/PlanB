package com.minhld.planb.controller;

import com.minhld.planb.model.InputMessage;
import com.minhld.planb.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ApiController {
    @Autowired
    KafkaService kafkaService;

    @PostMapping(value = "/api/sendMessage",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InputMessage> sendMessage(@RequestBody InputMessage inputMessage) {
        inputMessage.setDate(new Date().toString());
        kafkaService.sendMessage(inputMessage);
        return ResponseEntity.ok(inputMessage);
    }
}
