package com.xiayu.demo.cloud.feign.fallback;

import com.xiayu.demo.cloud.feign.MessageFeign;
import org.springframework.stereotype.Component;

@Component
public class MessageFeignFallback implements MessageFeign {

    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

}
