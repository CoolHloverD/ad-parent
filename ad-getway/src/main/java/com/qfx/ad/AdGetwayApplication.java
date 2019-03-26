package com.qfx.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class AdGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdGetwayApplication.class, args);
    }

}
