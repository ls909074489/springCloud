package com.king.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.king.service.FeignServiceHi;
import com.king.service.RestTemplateService;

@RestController
public class HelloControler {

    @Autowired
    private RestTemplateService restTemplateService;
    @Autowired
    private FeignServiceHi feignServiceHi;

    @GetMapping(value = "/restTemplateHi")
    public String restTemplateHi() {
        return restTemplateService.hi();
    }

    
    @GetMapping(value = "/feignHi")
    public String feignHi() {
        return feignServiceHi.hi();
    }
}
