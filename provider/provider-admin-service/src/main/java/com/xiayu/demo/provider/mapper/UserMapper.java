package com.xiayu.demo.provider.mapper;


import com.xiayu.demo.provider.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
     List<User> queryUserList();

     User findUserById(@Param("Id") String Id);

     /**
      * 注册用户
      * @param user
      * @return
      */
     int insert(User user);

     /**
      * 根据用户名称获取用户信息
      * @param name
      * @return
      */
     User findUerByName(@Param("name") String name);
}
