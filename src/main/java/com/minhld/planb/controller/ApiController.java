package com.minhld.planb.controller;

import com.minhld.planb.model.InputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @PostMapping(value = "/api/sendMessage",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> sendMessage(@RequestBody InputMessage inputMessage) {
        return ResponseEntity.ok(inputMessage.getMessage());
    }
}
