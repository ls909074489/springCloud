package com.king;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootAdminServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminServerApplication.class, args);
	}
	
	
	@Configuration
	public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

//	    private final String adminContextPath;
	//
//	    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
//	        this.adminContextPath = adminServerProperties.getContextPath();
//	    }
	//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        // @formatter:off
//	        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//	        successHandler.setTargetUrlParameter("redirectTo");
//	        successHandler.setDefaultTargetUrl(adminContextPath + "/");
	//
//	        http.authorizeRequests()
//	                //授予对所有静态资产和登录页面的公共访问权限。
//	                .antMatchers(adminContextPath + "/assets/**").permitAll()
//	                .antMatchers(adminContextPath + "/login").permitAll()
//	                //必须对每个其他请求进行身份验证
//	                .anyRequest().authenticated()
//	                .and()
//	                //配置登录和注销
//	                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//	                .logout().logoutUrl(adminContextPath + "/logout").and()
//	                //启用HTTP-Basic支持。这是Spring Boot Admin Client注册所必需的
//	                .httpBasic().and();
//	        // @formatter:on
//	    }
		
		
		 private final AdminServerProperties adminServer;
		 
	     /**
	      * Instantiates a new Security secure config.
	      *
	      * @param adminServer the admin server
	      */
	     public SecuritySecureConfig(AdminServerProperties adminServer) {
	         this.adminServer = adminServer;
	     }
	 
	     @Override
	     protected void configure(HttpSecurity http) throws Exception {
	         // @formatter:off
	         SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
	         successHandler.setTargetUrlParameter("redirectTo");
	         final String adminServerContextPath = this.adminServer.getContextPath();
	         successHandler.setDefaultTargetUrl(adminServerContextPath+"/");
	 
	         http.authorizeRequests()
	                 .antMatchers(adminServerContextPath + "/assets/**").permitAll() // <1>
	                 .antMatchers(adminServerContextPath + "/login").permitAll()
	                 .anyRequest().authenticated() // <2>
	                 .and()
	                 .formLogin().loginPage(adminServerContextPath + "/login").successHandler(successHandler).and() // <3>
	                 .logout().logoutUrl(adminServerContextPath + "/logout").and()
	                 .httpBasic().and() // <4>
	                 .csrf()
	                 .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // <5>
	                 .ignoringRequestMatchers(
	                         new AntPathRequestMatcher(adminServerContextPath + "/instances", HttpMethod.POST.toString()),  // <6>
	                         new AntPathRequestMatcher(adminServerContextPath + "/instances/*", HttpMethod.DELETE.toString()),  // <6>
	                         new AntPathRequestMatcher(adminServerContextPath + "/actuator/**")  // <7>
	                 )
	                 .and()
	                 .rememberMe().key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600);
	 
	     }
	}
}
