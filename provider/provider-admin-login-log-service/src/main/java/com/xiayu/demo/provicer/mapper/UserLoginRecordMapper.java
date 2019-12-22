package com.xiayu.demo.provicer.mapper;

import com.xiayu.demo.provicer.api.domain.UserLoginRecord;
import org.apache.ibatis.annotations.Mapper;
/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/20 17:34
 */

@Mapper
public interface UserLoginRecordMapper {

    /**
     * 插入信息
     *
     *@paramu  userAdminLoginLog  {@link UserLoginRecord}
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(UserLoginRecord userAdminLoginLog);
}
