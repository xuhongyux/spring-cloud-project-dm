package com.xiayu.demo.business.controller;


import com.google.common.collect.Maps;
import com.xiayu.demo.business.dto.LoginInfo;
import com.xiayu.demo.business.dto.LoginParam;
import com.xiayu.demo.business.feign.ProfileFeign;
import com.xiayu.demo.configuration.business.BusinessException;
import com.xiayu.demo.configuration.business.BusinessStatus;
import com.xiayu.demo.configuration.commons.dto.ResponseResult;
import com.xiayu.demo.configuration.commons.utils.MapperUtils;
import com.xiayu.demo.configuration.commons.utils.OkHttpClientUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 登录管理login
 * @author xiayu
 */
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9002/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;
  //todo 错误
    @Resource
    private ProfileFeign profileFeign;

    @PostMapping(value = "/user/login")
    public ResponseResult login(@RequestBody LoginParam loginParam, HttpServletRequest request){

        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();

        // 验证密码是否正确
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
        }
        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);

            // 发送登录日志
           // sendAdminLoginLog(userDetails.getUsername(), request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(HttpStatus.OK.value(), "登录成功", result);
    }
    /**
     * 获取用户信息
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() throws Exception {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取个人信息
        //String jsonString = profileFeign.info(authentication.getName());
        //User umsAdmin = MapperUtils.json2pojoByTree(jsonString, "data", User.class);
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
       // loginInfo.setNickName(umsAdmin.getUsername());
        return  new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK,"获取用户信息",loginInfo);
    }
    @PostMapping(value =  "/user/logout")
    public  ResponseResult<Void> logout(HttpServletRequest request){
        String token = request.getParameter("access_token");
        //token不是删除的，我们需要用TokenStore 来操作token
        //我们在AuthorizationServerConfiguration 设置TokenStore 注入进来进行对token的操作
        //将token读到accesstoek中
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        //移除token
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return  new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"用户注销",null);
    }
   /* *//**
     * 获取用户信息
     *
     * @return {@link ResponseResult}
     *//*
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() throws Exception {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 获取个人信息
        String jsonString = profileFeign.info(authentication.getName());
        UmsAdmin umsAdmin = MapperUtils.json2pojoByTree(jsonString, "data", UmsAdmin.class);

        // 如果触发熔断则返回熔断结果
        if (umsAdmin == null) {
            return MapperUtils.json2pojo(jsonString, ResponseResult.class);
        }

        // 封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(umsAdmin.getUsername());
        loginInfo.setAvatar(umsAdmin.getIcon());
        loginInfo.setNickName(umsAdmin.getNickName());
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }*/



/*
    *//**
     * 发送登录日志
     *
     * @param request {@link HttpServletRequest}
     *//*
    private void sendAdminLoginLog(String username, HttpServletRequest request) {
        UmsAdmin umsAdmin = umsAdminService.get(username);

        if (umsAdmin != null) {
            // 获取请求的用户代理信息
            Browser browser = UserAgentUtils.getBrowser(request);
            String ip = UserAgentUtils.getIpAddr(request);
            String address = UserAgentUtils.getIpInfo(ip).getCity();

            UmsAdminLoginLogDTO dto = new UmsAdminLoginLogDTO();
            dto.setAdminId(umsAdmin.getId());
            dto.setCreateTime(new Date());
            dto.setIp(ip);
            dto.setAddress(address);
            dto.setUserAgent(browser.getName());

            messageService.sendAdminLoginLog(dto);
        }
    }*/
}
