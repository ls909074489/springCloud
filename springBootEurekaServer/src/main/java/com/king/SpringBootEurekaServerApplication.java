package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServerApplication.class, args);
	}
	
	
	@EnableWebSecurity
    public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable();
        	http.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(http);
        }
    }

}
