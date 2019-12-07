package com.xiayu.demo.business;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test(){

        System.out.println(new BCryptPasswordEncoder().encode("123456"));

    }
}
