package com.xiayu.demo.provicer.api;


import com.xiayu.demo.provicer.api.domain.UserAdminLoginLog;

/**
 * 系统登录日志服务
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 */
public interface UserAdminLoginLogService {
    /**
     * 新增日志
     *
     * @param userAdminLoginLog {@link UserAdminLoginLog }
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(UserAdminLoginLog userAdminLoginLog);

}
