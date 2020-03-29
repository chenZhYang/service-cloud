package com.chen.eureka.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 11:09
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationB.class, args);
    }
}
