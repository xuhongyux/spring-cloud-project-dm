package com.xiayu.demo.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录参数
 * <p>
 * Description:
 * </p>
 */
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;

}
