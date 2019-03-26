package com.qfx.ad.advice;

import com.qfx.ad.exception.AdException;
import com.qfx.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Qingfengxu
 * @version V1.0
 * @date 2019/3/26 16:43
 * 统一处理异常的类
 */
@RestControllerAdvice //增强
public class GrobalExceptionAdvice {

    /**
     * @param request
     * @param ex
     * @return 相应的数据
     * 统一对异常处理   可以有多个
     */
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handleException(HttpServletRequest request, AdException ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "服务器繁忙");
        response.setDate(ex.getMessage());
        return response;
    }
}
