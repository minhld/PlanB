package com.minhld.planb.controller;

import com.minhld.planb.model.RequestUser;
import com.minhld.planb.service.SecurityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class LoginControllerTest {
    @Mock
    SecurityService securityService;

    @InjectMocks
    LoginController loginController;

    RequestUser requestUser;

    @BeforeEach
    void setup() {
        requestUser = RequestUser.builder()
                .username("test")
                .password("test")
                .build();
    }

    @Test
    void testGetUser() {
        Mockito.when(securityService.login(requestUser.getUsername(), requestUser.getPassword()))
                .thenReturn(true);
        ResponseEntity<String> res = loginController.getUser(requestUser);
        Assertions.assertEquals(requestUser.getUsername(), res.getBody());
    }

    @Test
    void testGetUser_notFound() {
        Mockito.when(securityService.login(requestUser.getUsername(), requestUser.getPassword()))
                .thenReturn(false);
        ResponseEntity<String> res = loginController.getUser(requestUser);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
    }

    @Test
    void testSaveUser() {
        Mockito.when(securityService.save(requestUser.getUsername(), requestUser.getPassword()))
                .thenReturn(true);
        ResponseEntity<String> res = loginController.saveUser(requestUser);
        Assertions.assertEquals(requestUser.getUsername(), res.getBody());
    }

    @Test
    void testSaveUser_serverError() {
        Mockito.when(securityService.save(requestUser.getUsername(), requestUser.getPassword()))
                .thenReturn(false);
        ResponseEntity<String> res = loginController.saveUser(requestUser);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, res.getStatusCode());
    }
}
