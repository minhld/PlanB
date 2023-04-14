package com.minhld.planb.exception;

public class LoginException extends RuntimeException {
    public LoginException(String username) {
        super(String.format("Login failed with user %s", username));
    }
}
