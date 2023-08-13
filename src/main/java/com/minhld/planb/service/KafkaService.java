package com.minhld.planb.service;

import com.minhld.planb.model.InputMessage;

public interface KafkaService {
    void sendMessage(InputMessage inputMessage);
}
