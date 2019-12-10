package com.xiayu.demo.business.controller;


import com.xiayu.demo.business.dto.LoginParam;
import com.xiayu.demo.configuration.commons.dto.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录管理login
 */
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @PostMapping(value = "/user/login")
    public ResponseResult login(@RequestBody LoginParam loginParam){
        System.out.println(loginParam.getPassword());
        return new ResponseResult<>(HttpStatus.OK.value(), "登录成功", null);
    }

}
