package com.qfx.ad.advice;

import com.qfx.ad.annotation.IgnoreResponseAdvice;
import com.qfx.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author Qingfengxu
 * @version V1.0
 * @date 2019/3/26 15:45
 * ResponseBodyAdvice  控制哪些响应 以及所做的处理
 * 统一响应处理
 */
@RestControllerAdvice //控制器增强
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * @param methodParameter 2
     * @param aClass          1
     * @return 是否拦截
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(
                IgnoreResponseAdvice.class
        ) && (!methodParameter.getClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        ));
    }

    /**
     * 写入响应前
     *
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonResponse<Object> response = new CommonResponse<>(0, "");
        if (o == null) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
        }else {
            response.setDate(o);
        }
        return response;
    }
}
