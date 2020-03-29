package com.chen.consume.a.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/29 14:25
 */
@Component
public class ApiFallback implements FallbackFactory<ApiServiceClient> {

    @Override
    public ApiServiceClient create(Throwable throwable) {
        final String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            System.out.println("到这了"+msg);
        }
        return new ApiServiceClient() {
            @Override
            public String hello(@RequestParam("param") String param) {
                return msg;
            }
        };
    }
}
