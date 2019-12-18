package com.xiayu.demo.business.feign;


import com.xiayu.demo.business.dto.params.IconParam;
import com.xiayu.demo.business.dto.params.PasswordParam;
import com.xiayu.demo.business.dto.params.ProfileParam;
import com.xiayu.demo.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 */
//value 服务名称  path  请求服务 的Controller 的RequestMapping Value
@FeignClient(value = "business-profile", path = "profile", configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);









    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~美妙的波浪线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/*    *//**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     *//*
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    *//**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@code String} JSON
     *//*
    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    *//**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@code String} JSON
     *//*
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);
    */

}
