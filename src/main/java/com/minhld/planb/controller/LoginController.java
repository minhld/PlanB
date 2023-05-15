package com.minhld.planb.controller;

import com.minhld.planb.model.RequestUser;
import com.minhld.planb.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/user/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST)
    public ResponseEntity getUser(@Valid @RequestBody RequestUser user) {
        boolean userExist = securityService.login(user.getUsername(), user.getPassword());
        return userExist
                ? ResponseEntity.ok(user.getUsername())
                : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/user/save",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST)
    public ResponseEntity saveUser(@Valid @RequestBody RequestUser user) {
        boolean saveSuccessful = securityService.save(user.getUsername(), user.getPassword());
        return saveSuccessful
                ? ResponseEntity.ok(user.getUsername())
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
