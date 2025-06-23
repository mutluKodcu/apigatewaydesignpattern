package com.uyg2.dmtbkts.apigateway;

import com.uyg2.dmtbkts.apigateway.filter.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public WebFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}