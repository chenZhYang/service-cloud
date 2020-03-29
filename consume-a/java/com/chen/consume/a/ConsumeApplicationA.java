package com.chen.consume.a;

import com.chen.consume.a.client.ApiServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 12:34
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableFeignClients
@EnableCircuitBreaker
@EnableZuulProxy
public class ConsumeApplicationA {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplicationA.class, args);
    }

    @Autowired
    ApiServiceClient apiServiceClient;

    @RequestMapping("/feignHello")
    public String feignHello(String param){
        return apiServiceClient.hello(param);
    }

}
