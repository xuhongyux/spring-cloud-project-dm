package com.xiayu.demo.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiayu.demo.provider.api.UserAdminService;
import com.xiayu.demo.provider.domain.User;
import com.xiayu.demo.provider.mapper.UserMapper;
import com.xiayu.demo.provider.service.fallback.UmsAdminServiceFallback;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 */
@Service(version = "1.0.0",timeout = 50000)
public class UserAdminServiceImpl implements UserAdminService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    /**
     * 新增用户
     *
     * @param user {@link User}
     * @return {@code int} 大于 0 则表示添加成功
     */
    @Override
    public int insert(User user) {
        // 初始化用户对象
        initUmsAdmin(user);
        return userMapper.insert(user);
    }

    /**
     * 熔断器的使用
     *
     * <p>
     * 1.  {@link SentinelResource#value()} 对应的是 Sentinel 控制台中的资源，可用作控制台设置【流控】和【降级】操作 <br>
     * 2.  {@link SentinelResource#fallback()} 对应的是 并且必须为 `static` <br>
     * 3. 如果不设置 {@link SentinelResource#fallbackClass()}，则需要在当前类中创建一个 `Fallback` 函数，函数签名与原函数一致或加一个 {@link Throwable} 类型的参数
     * </p>
     * @param username {@code String} 用户名
     * @return {@link User}
     */
    @Override
    //value 控制台显示的名称   fallback 熔断配置类的方法   fallbackClass  熔断配置类的类名
    @SentinelResource(value = "getByUsername", fallback = "getByUsernameFallback", fallbackClass = UmsAdminServiceFallback.class)
    public User get(String username) {
        User user = userMapper.findUerByName(username);
        return user;
    }

    /**
     * 获取用户
     *
     * @param user {@link User}
     * @return {@link User}
     */
    @Override
    public User get(User user) {
        return null;
    }

    /**
     * 更新用户
     * <p>
     * 仅允许更新 邮箱、昵称、备注、状态
     * </p>
     *
     * @param umsAdmin {@link User}
     * @return {@code int} 大于 0 则表示更新成功
     */
    @Override
    public int update(User umsAdmin) {
        return 0;
    }

    /**
     * 修改密码
     *
     * @param username {@code String} 用户名
     * @param password {@code String} 明文密码
     * @return {@code int} 大于 0 则表示更新成功
     */
    @Override
    public int modifyPassword(String username, String password) {
        return 0;
    }

    /**
     * 修改头像
     *
     * @param username {@code String} 用户名
     * @param path     {@code String} 头像地址
     * @return {@code int} 大于 0 则表示更新成功
     */
    @Override
    public int modifyIcon(String username, String path) {
        return 0;
    }



    /**
     * 初始化用户对象
     *
     * @param user {@link User}
     */
    private void initUmsAdmin(User user) {
        // 初始化创建时间
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());

        // 初始化状态
        if (user.getStatus() == null) {
            user.setStatus(0);
        }
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
