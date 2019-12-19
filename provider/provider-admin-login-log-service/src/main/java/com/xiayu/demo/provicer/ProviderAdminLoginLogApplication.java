package com.xiayu.demo.provicer;


import com.xiayu.demo.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {ProviderAdminLoginLogApplication.class, DubboSentinelConfiguration.class})
public class ProviderAdminLoginLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminLoginLogApplication.class, args);
    }

}
