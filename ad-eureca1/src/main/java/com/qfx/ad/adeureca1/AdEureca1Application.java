package com.qfx.ad.adeureca1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AdEureca1Application {

    public static void main(String[] args) {
        SpringApplication.run(AdEureca1Application.class, args);
    }

}
