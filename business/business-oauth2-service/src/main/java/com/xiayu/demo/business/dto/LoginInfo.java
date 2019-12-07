package com.xiayu.demo.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录信息
 * <p>
 * Description:
 * </p>
 *
 */
@Data
public class LoginInfo implements Serializable {
    private String name;
    private String avatar;
    private String nickName;
}
