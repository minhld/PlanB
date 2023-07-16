package com.minhld.planb.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ExceptionControllerTest {
    @Autowired
    ExceptionController exceptionController;

    @DisplayName("test login exception")
    @Test
    void testException() {
        LoginException e = Mockito.mock(LoginException.class);
        ResponseEntity entity = exceptionController.exception(e);
        Assertions.assertEquals(entity.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
    }
}
