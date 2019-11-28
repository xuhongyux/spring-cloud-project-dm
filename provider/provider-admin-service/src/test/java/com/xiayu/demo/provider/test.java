package com.xiayu.demo.provider;


import com.xiayu.demo.provider.api.UserAdminService;
import com.xiayu.demo.provider.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //让测试运行于Spring测试环境
@SpringBootTest
@Rollback //回滚
public class test {


    @Autowired
    private UserAdminService userAdminService;


    /**
     * 插入用户
     */
    @Test
    public  void insertUser(){
        User user = new User();
        user.setId(1234);
        user.setName("888");
        user.setPassword("123456");
        user.setUsername("张三");
        int insert = userAdminService.insert(user);
        System.out.print(insert);
        Assert.assertEquals(insert, 1);
    }

}
