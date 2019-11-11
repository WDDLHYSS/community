package com.wddlhyss.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class IndexController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
