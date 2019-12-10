package com.xiayu.demo.business.service;


import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义认证
 * <p>
 * Description:
 * </p>
 *
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {



    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$fe2B/M.YvJZYLOvQ5BQzH.Ny79rrYxxVW8mi5Inm9ElpQQ1K4bk2O";
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }


   /* private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$YNUV/BtCel2orbhgrxyPJeljdKVty6yTAL.Cj4v3XhwHWXBkgyPYW";

    @Reference(version = "1.0.0")
    private UserAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询用户
        com.xiayu.demo.provider.domain.User user = umsAdminService.get(userName);

        // 默认所有用户拥有 USER 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);

        // 用户存在
        if (user != null) {

            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
        // 用户不存在
        else {
            return null;
        }
    }*/

}
