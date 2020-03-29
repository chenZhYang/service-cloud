package com.chen.consume.b;

import com.chen.consume.b.zuul.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@EnableZuulProxy
public class ConsumeApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplicationB.class, args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }


}
