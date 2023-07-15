package com.minhld.planb.controller;

import com.minhld.planb.service.SecurityService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginControllerTest {
    @Autowired
    SecurityService securityService;

    @InjectMocks
    LoginController loginController;

    @Test
    void testGetUser() {

    }

    @Test
    void testGetUser_notFound() {

    }

    @Test
    void testSaveUser() {

    }

    @Test
    void testSaveUser_serverError() {

    }
}
