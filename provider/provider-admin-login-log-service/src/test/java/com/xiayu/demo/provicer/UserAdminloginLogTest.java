package com.xiayu.demo.provicer;


import com.xiayu.demo.provicer.api.UserAdminLoginLogService;
import com.xiayu.demo.provicer.api.domain.UserLoginRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class) //让测试运行于Spring测试环境
@SpringBootTest
@Rollback //回滚
public class UserAdminloginLogTest {
    @Resource
    private UserAdminLoginLogService userAdminLoginLogService;


    @Test
    public void  testInsert(){
        UserLoginRecord userLoginRecord = new UserLoginRecord();
        Date date = new Date();
        userLoginRecord.setId("我是ID");
       // userLoginRecord.setUserId("我是setUserId");
        userLoginRecord.setCreateTime(date);
        userLoginRecord.setIp("我是Ip");
        userLoginRecord.setAddress("我是address");
        userLoginRecord.setUserAgent("我是Useragent");
        userLoginRecord.setReserve("我是reserv");
        userLoginRecord.setUpdateTime(date);
        userLoginRecord.setDelFlag(0);
        userLoginRecord.setVersion("我是version");








        userAdminLoginLogService.insert(userLoginRecord);
    }



}
