package com.minhld.planb.service;

public interface SecurityService {
    boolean login(String username, String password);

    boolean save(String username, String password);
}
