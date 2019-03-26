package com.qfx.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Qingfengxu
 * @version V1.0
 * @date 2019/3/26 15:12
 */
@Slf4j
@Component
public class AcesscsLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Long startTime = (Long) currentContext.get("startTime");
        String requestURI = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;
        log.info("uri: " + requestURI +", duration: " + duration/100 + "ms");
        return null;
    }
}
