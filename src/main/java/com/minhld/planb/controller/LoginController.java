package com.minhld.planb.controller;

import com.minhld.planb.data.object.User;
import com.minhld.planb.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/user/login")
    public ResponseEntity getUser(@RequestParam("user") User user) {
        boolean userExist = securityService.login(user.getUsername(), user.getPassword());
        return userExist
                ? ResponseEntity.ok(user.getUsername())
                : ResponseEntity.notFound().build();
    }
}
