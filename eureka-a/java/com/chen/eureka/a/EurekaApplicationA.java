package com.chen.eureka.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 11:09
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationA {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationA.class, args);
    }
}
