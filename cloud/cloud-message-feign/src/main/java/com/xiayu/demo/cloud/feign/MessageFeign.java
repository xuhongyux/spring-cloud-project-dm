package com.xiayu.demo.cloud.feign;


import com.xiayu.demo.cloud.feign.fallback.MessageFeignFallback;
import com.xiayu.demo.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cloud-message", path = "message", configuration = FeignRequestConfiguration.class, fallback = MessageFeignFallback.class)
public interface MessageFeign {

}
