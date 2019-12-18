package com.xiayu.demo.busines.controller;

import com.xiayu.demo.configuration.commons.dto.ResponseResult;
import com.xiayu.demo.provider.api.UserAdminService;
import com.xiayu.demo.provider.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 个人信息管理
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/16 19:49
 */
@RestController
@RequestMapping(value = "profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UserAdminService umsAdminService;
    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult}
     */
   // @SentinelResource(value = "info", fallback = "infoFallback", fallbackClass = ProfileControllerFallback.class)
    //@SentinelResource(value = "info", fallback = "infoFallback")
    @GetMapping(value = "info/{username}")
    public ResponseResult<User> info(@PathVariable String username) {
        User umsAdmin = umsAdminService.get(username);

        return new ResponseResult<User>(ResponseResult.CodeStatus.OK, "查询用户信息", umsAdmin);
    }
}
