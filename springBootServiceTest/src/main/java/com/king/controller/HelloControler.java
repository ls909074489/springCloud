package com.king.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {


    @RequestMapping(value = "/ping")
    public String feignHi() {
        return "this springBoot services";
    }
}
