package com.xiayu.demo.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*

@EnableDiscoveryClient
@EnableFeignClients
//@SpringBootApplication(scanBasePackageClasses = {BusinessOAuth2Application.class}, scanBasePackages = "com.funtl.myshop.plus.cloud.feign")
*/

@SpringBootApplication
public class BusinessOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOAuth2Application.class, args);
    }

}
