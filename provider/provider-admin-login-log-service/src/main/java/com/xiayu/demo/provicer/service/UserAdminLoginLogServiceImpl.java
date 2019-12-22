package com.xiayu.demo.provicer.service;

import com.xiayu.demo.provicer.api.UserAdminLoginLogService;
import com.xiayu.demo.provicer.api.domain.UserLoginRecord;
import com.xiayu.demo.provicer.mapper.UserLoginRecordMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/20 17:19
 */
@Service(version = "1.0.0")
public class UserAdminLoginLogServiceImpl implements UserAdminLoginLogService {

    @Resource
    private UserLoginRecordMapper userLoginRecordMapper;
    /**
     * 新增日志
     *
     * @param userAdminLoginLog {@link UserLoginRecord }
     * @return {@code int} 大于 0 则表示添加成功
     */
    @Override
    public int insert(UserLoginRecord userAdminLoginLog) {

        return userLoginRecordMapper.insert(userAdminLoginLog);
    }

}
