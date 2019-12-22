package com.xiayu.demo.provicer.api.domain;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/19 19:31
 */

@Data

public class UserLoginRecord {



    private String id;


    //private String userId;


    private Date createTime;


    private String ip;


    private String address;
    /**
     * 浏览器登录类型
     */

    private String userAgent;


    /**
     * 预留字段
     */

    private String reserve;





    private Date updateTime;


    /**
     * 删除标志
     */

    private Integer delFlag;


    /**
     * 版本标志
     */

    private String version;

}
