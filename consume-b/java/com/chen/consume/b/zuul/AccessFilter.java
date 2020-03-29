package com.chen.consume.b.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Aaron chen
 * @Date: 2020/3/29 15:52
 */
@RefreshScope
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * 当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行
     * @return  true：需要执行，false：不需要执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        System.out.println("send "+httpServletRequest.getMethod()+" request to "+httpServletRequest.getRequestURL());
        Object accessToken = httpServletRequest.getParameter("accessToken");
        if(accessToken == null){
            System.out.println("accessToken is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("accessToken is empty");
            return null;
        }
        System.out.println("accessToken is ok");
        return null;
    }
}
