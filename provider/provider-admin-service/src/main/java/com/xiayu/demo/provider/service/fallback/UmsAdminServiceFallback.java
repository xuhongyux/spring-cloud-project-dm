package com.xiayu.demo.provider.service.fallback;


import com.xiayu.demo.provider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 *用户服务提供者
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/22 16:31
 */
public class UmsAdminServiceFallback {

    private static final Logger logger = LoggerFactory.getLogger(UmsAdminServiceFallback.class);

    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @param ex       {@code Throwable} 异常信息
     * @return {@link User} 熔断后的固定结果
     */
    public static User getByUsernameFallback(String username, Throwable ex) {
        logger.warn("Invoke getByUsernameFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }

}
