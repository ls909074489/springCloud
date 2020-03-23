package com.king;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class SpringBootEurekaClientApplication {
	
	/*
	 * Feign是自带断路器的，在D版本的Spring Cloud之后，它没有默认打开。
	 * 需要在配置文件中配置打开它，在配置文件加以下代码：feign.hystrix.enabled=true
	*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaClientApplication.class, args);
	}

	
	@RequestMapping("/ping")
	public String ping(){
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = dtf.format(localDateTime);

		log.info(">>>>>>>>>>>>>记录当前时间：普通时间： {}, 本地时间： {}",time, localTime);
		log.error(">>>>>>>>>>>>>记录当前时间：普通时间： {}, 本地时间： {}",time, localTime);
		return "pong";
	}
}
