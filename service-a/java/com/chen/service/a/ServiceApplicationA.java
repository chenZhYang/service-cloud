package com.chen.service.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/28 12:40
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceApplicationA {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplicationA.class,args);
    }

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/hello")
    public String hello(@RequestParam String param){
        System.out.println("进来了："+param+",IP:"+httpServletRequest.getRequestURL());
        return "OK："+param+",IP:"+httpServletRequest.getRequestURL();
    }
}
