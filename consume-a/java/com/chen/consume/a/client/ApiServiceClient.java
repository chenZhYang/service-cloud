package com.chen.consume.a.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/29 2:23
 */
@FeignClient(value = "service-a",fallbackFactory = ApiFallback.class)
public interface ApiServiceClient {

    @RequestMapping("/hello")
    String hello(@RequestParam("param") String param);
}
