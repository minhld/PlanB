package com.minhld.planb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/main")
    public ModelAndView goMain() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }
}
