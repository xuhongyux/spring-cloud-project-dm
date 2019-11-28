package com.xiayu.demo.provider.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户
 * <p>
 * Description:
 * </p>
 *

 */
@Data
public class UmsAdmin implements Serializable {

    private static final long serialVersionUID = -5604007880179803027L;


    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
}

/*
@Data
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {

    private static final long serialVersionUID = -5604007880179803027L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    */
/**
     * 头像
     *//*

    @Column(name = "icon")
    private String icon;

    */
/**
     * 邮箱
     *//*

    @Column(name = "email")
    private String email;

    */
/**
     * 昵称
     *//*

    @Column(name = "nick_name")
    private String nickName;

    */
/**
     * 备注信息
     *//*

    @Column(name = "note")
    private String note;

    */
/**
     * 创建时间
     *//*

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    */
/**
     * 最后登录时间
     *//*

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "login_time")
    private Date loginTime;

    */
/**
     * 帐号启用状态：0->禁用；1->启用
     *//*

    @Column(name = "`status`")
    private Integer status;
}*/
