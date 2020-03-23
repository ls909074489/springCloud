package com.king.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi() {
        return restTemplate.getForObject( "http://SBSERVICES/ping" , String.class );
    }

    
    public String hiError() {
        return "sorry ，server error";
    }
}
