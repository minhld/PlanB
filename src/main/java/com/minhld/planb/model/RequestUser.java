package com.minhld.planb.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestUser {
    private String username;
    private String password;
}
