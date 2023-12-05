package com.example.ApiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ApiGateWayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiGateWayApplication.class, args);
	}

}
