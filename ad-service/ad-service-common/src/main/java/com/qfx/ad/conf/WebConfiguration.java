package com.qfx.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Qingfengxu
 * @version V1.0
 * @date 2019/3/26 16:52
 * 消息转换器
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * @param converters
     * 自定义消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        //java-->json对象     application/json
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
