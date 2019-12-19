package com.xiayu.demo.business.controller;


import com.xiayu.demo.configuration.commons.dto.ResponseResult;
import com.xiayu.demo.provider.api.UserAdminService;
import com.xiayu.demo.provider.domain.User;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册.
 * <p>
 * Description:
 * </p>
 *
 */
@RestController
@RequestMapping(value = "reg")
@Api(value = "/user")
public class RegController {

    @Reference(version = "1.0.0")
    private UserAdminService userAdminService;

    /**
     * 注册
     *
     * @param user {@link User}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "")
    public ResponseResult<User> reg(@RequestBody User user) {
        String message = validateReg(user);

        // 通过验证
        if (message == null) {
            int result = userAdminService.insert(user);

            // 注册成功
            if (result > 0) {
                User admin = userAdminService.get(user.getUsername());
                return new ResponseResult<User>(HttpStatus.OK.value(), "用户注册成功", admin);
            }
        }
        return new ResponseResult<User>(HttpStatus.NOT_ACCEPTABLE.value(), message != null ? message : "用户注册失败");
    }

    /**
     * 注册信息验证
     *
     * @param user {@link User}
     * @return 验证结果
     */
    private String validateReg(User user) {
        User admin = userAdminService.get(user.getUsername());
        if (admin != null) {
            return "用户名已存在，请重新输入";
        }
        return null;
    }

}
