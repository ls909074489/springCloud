package com.king.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sbServices", fallback = HystrixClientFallback.class)
public interface FeignServiceHi {

    @GetMapping("/ping")
    String hi();
    
}