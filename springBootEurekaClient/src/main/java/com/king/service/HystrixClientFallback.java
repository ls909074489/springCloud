package com.king.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements FeignServiceHi {

	//Feign是自带断路器的，在D版本的Spring Cloud之后，它没有默认打开。
	//需要在配置文件中配置打开它，在配置文件加以下代码：feign.hystrix.enabled=true
	
	
	@Override
	public String hi() {
		return "sorry , server error";
	}
}
