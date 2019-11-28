package com.xiayu.demo.provider.service;


import com.xiayu.demo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String string) {
        return "Hello Dubbo" + string;
    }
}
